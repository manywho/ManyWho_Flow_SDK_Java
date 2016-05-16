package com.manywho.sdk.services.actions;

import com.google.inject.Injector;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.api.run.elements.config.ServiceResponse;
import com.manywho.sdk.services.describe.DescribeActionService;
import com.manywho.sdk.services.values.Value;
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

    @Inject
    public ActionManager(Injector injector, ActionRepository actionRepository, ValueParser valueParser) {
        this.injector = injector;
        this.actionRepository = actionRepository;
        this.valueParser = valueParser;
    }

    public ServiceResponse executeAction(String path, ServiceRequest serviceRequest) {
        Class<? extends Action> action = actionRepository.getActions().stream()
                .filter(type -> type.isAnnotationPresent(Action.Metadata.class))
                .filter(type -> type.getAnnotation(Action.Metadata.class).uri().equals(path))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("An action could not be found with the URI part " + path));

        Type[] types = DescribeActionService.getTypeArguments(action);

        try {
            Object inputObject = Class.forName(types[0].getTypeName()).newInstance();

            for (Field field : findInputFields(types[0])) {
                Value.Property annotation = field.getAnnotation(Value.Property.class);

                Optional<EngineValue> optional = serviceRequest.getInputs().stream()
                        .filter(i -> i.getDeveloperName().equals(annotation.name()))
                        .findFirst();

                optional.ifPresent(input -> valueParser.populateObjectField(inputObject, field, input));
            }

            ActionResponse actionResponse = injector.getInstance(action).execute(inputObject);

            List<EngineValue> outputs = findOutputFields(types[1]).stream()
                    .map(output -> createOutputValue(actionResponse.getOutputs(), output))
                    .collect(Collectors.toList());

            return new ServiceResponse(actionResponse.getInvokeType(), outputs, serviceRequest.getToken(), actionResponse.getWaitMessage());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException("Unable to execute the message action for the path " + path, e);
        }
    }

    List<Field> findInputFields(Type type) {
        return actionRepository.getInputFields().stream()
                .filter(input -> input.getDeclaringClass().equals(type))
                .collect(Collectors.toList());
    }

    List<Field> findOutputFields(Type type) {
        return actionRepository.getOutputFields().stream()
                .filter(output -> output.getDeclaringClass().equals(type))
                .collect(Collectors.toList());
    }

    static EngineValue createOutputValue(Object outputs, Field field) {
        Value.Property property = field.getAnnotation(Value.Property.class);

        AccessController.doPrivileged((PrivilegedAction) () -> {
            field.setAccessible(true);
            return null;
        });

        try {
            return new EngineValue(property.name(), property.contentType(), field.get(outputs));
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to get the value of the output for the field " + field.getName());
        }
    }
}
