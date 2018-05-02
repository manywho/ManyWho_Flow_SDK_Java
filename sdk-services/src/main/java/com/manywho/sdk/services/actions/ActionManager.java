package com.manywho.sdk.services.actions;

import com.google.common.collect.Lists;
import com.google.inject.Injector;
import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.api.run.elements.config.ServiceResponse;
import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.configuration.ConfigurationParser;
import com.manywho.sdk.services.describe.DescribeActionService;
import com.manywho.sdk.services.values.ValueBuilder;
import com.manywho.sdk.services.values.ValueParser;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
public class ActionManager {
    private final Injector injector;
    private final ActionRepository actionRepository;
    private final ValueParser valueParser;
    private final ConfigurationParser configurationParser;
    private final ValueBuilder valueBuilder;
    private final ActionHandler actionHandler;

    @Inject
    public ActionManager(
            Injector injector,
            ActionRepository actionRepository,
            ValueParser valueParser,
            ConfigurationParser configurationParser,
            ValueBuilder valueBuilder,
            ActionHandler actionHandler) {
        this.injector = injector;
        this.actionRepository = actionRepository;
        this.valueParser = valueParser;
        this.configurationParser = configurationParser;
        this.valueBuilder = valueBuilder;
        this.actionHandler = actionHandler;
    }

    public ServiceResponse executeAction(String path, ServiceRequest serviceRequest) {
        Configuration configuration = configurationParser.from(serviceRequest);

        if (actionHandler.canHandleAction(path, configuration, serviceRequest)) {
            return actionHandler.handleRaw(path, configuration, serviceRequest);
        }

        Class<?> action = actionRepository.getActions().stream()
                .filter(type -> type.isAnnotationPresent(Action.Metadata.class))
                .filter(type -> type.getAnnotation(Action.Metadata.class).uri().equals(path))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("An action could not be found with the URI part " + path));

        Class<? extends ActionCommand> command = actionRepository.getActionCommands().stream()
                .filter(a -> DescribeActionService.getTypeArguments(a)[1].equals(action))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No action command for the action " + action.getName() + " was found"));

        Type[] types = DescribeActionService.getTypeArguments(command);

        try {
            Class<?> inputClass = Class.forName(types[2].getTypeName());

            // If the input class inherit from Void then we don't want to instantiate it (because we can't)
            Object inputObject = null;
            if (Void.class.isAssignableFrom(inputClass) == false) {
                inputObject = inputClass.newInstance();
            }

            if (serviceRequest.hasInputs()) {
                for (Field field : findInputFields(types[2])) {
                    Action.Input annotation = field.getAnnotation(Action.Input.class);

                    Optional<EngineValue> optional = serviceRequest.getInputs().stream()
                            .filter(i -> i.getDeveloperName().equals(annotation.name()))
                            .findFirst();

                    Object finalInputObject = inputObject;

                    optional.ifPresent(input -> valueParser.populateObjectField(finalInputObject, field, annotation.contentType(), input));
                }
            }

            ActionResponse actionResponse = injector.getInstance(command).execute(
                    configuration,
                    serviceRequest,
                    inputObject
            );

            List<Field> outputFields = findOutputFields(types[3]);

            if (!outputFields.isEmpty() && actionResponse.getOutputs() == null && !actionResponse.getInvokeType().equals(InvokeType.Wait)) {
                throw new RuntimeException("The action response is expecting one or more outputs");
            }

            List<EngineValue> outputs = Lists.newArrayList();

            if (actionResponse.getOutputs() != null) {
                outputs = outputFields.stream()
                        .map(output -> createOutputValue(actionResponse.getOutputs(), output))
                        .collect(Collectors.toList());
            }

            return new ServiceResponse(
                    serviceRequest.getTenantId(),
                    actionResponse.getInvokeType(),
                    outputs,
                    serviceRequest.getToken(),
                    actionResponse.getWaitMessage()
            );
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException("Unable to execute the message action for the path " + path, e);
        }
    }

    private List<Field> findInputFields(Type type) {
        return actionRepository.getInputFields().stream()
                .filter(input -> input.getDeclaringClass().equals(type))
                .collect(Collectors.toList());
    }

    private List<Field> findOutputFields(Type type) {
        return actionRepository.getOutputFields().stream()
                .filter(output -> output.getDeclaringClass().equals(type))
                .collect(Collectors.toList());
    }

    public EngineValue createOutputValue(Object outputs, Field field) {
        Action.Output property = field.getAnnotation(Action.Output.class);

        AccessController.doPrivileged((PrivilegedAction) () -> {
            field.setAccessible(true);
            return null;
        });

        try {
            return valueBuilder.from(property.name(), property.contentType(), field.get(outputs));
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to get the value of the output for the field " + field.getName());
        }
    }
}
