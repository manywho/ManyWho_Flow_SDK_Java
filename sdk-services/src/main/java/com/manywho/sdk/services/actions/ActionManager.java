package com.manywho.sdk.services.actions;

import com.google.common.collect.Lists;
import com.google.inject.Injector;
import com.google.inject.Provider;
import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.api.run.elements.config.ServiceResponse;
import com.manywho.sdk.api.security.AuthenticatedWho;
import com.manywho.sdk.client.run.RunClient;
import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.configuration.ConfigurationParser;
import com.manywho.sdk.services.describe.DescribeActionService;
import com.manywho.sdk.services.identity.AuthorizationEncoder;
import com.manywho.sdk.services.values.ValueBuilder;
import com.manywho.sdk.services.values.ValueParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Singleton
public class ActionManager {
    private final static Logger LOGGER = LoggerFactory.getLogger(ActionManager.class);
    private final static Executor executor = Executors.newWorkStealingPool();

    private final Injector injector;
    private final ActionRepository actionRepository;
    private final ValueParser valueParser;
    private final ConfigurationParser configurationParser;
    private final ValueBuilder valueBuilder;
    private final Provider<AuthenticatedWho> authenticatedWhoProvider;
    private final AuthorizationEncoder authorizationEncoder;
    private final RunClient runClient;

    @Inject
    public ActionManager(
            Injector injector,
            ActionRepository actionRepository,
            ValueParser valueParser,
            ConfigurationParser configurationParser,
            ValueBuilder valueBuilder,
            Provider<AuthenticatedWho> authenticatedWhoProvider,
            AuthorizationEncoder authorizationEncoder,
            RunClient runClient) {
        this.injector = injector;
        this.actionRepository = actionRepository;
        this.valueParser = valueParser;
        this.configurationParser = configurationParser;
        this.valueBuilder = valueBuilder;
        this.authenticatedWhoProvider = authenticatedWhoProvider;
        this.authorizationEncoder = authorizationEncoder;
        this.runClient = runClient;
    }

    public ServiceResponse executeAction(String path, ServiceRequest serviceRequest) {
        Class<?> action = actionRepository.getActions().stream()
                .filter(type -> type.isAnnotationPresent(Action.Metadata.class))
                .filter(type -> type.getAnnotation(Action.Metadata.class).uri().equals(path))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("An action could not be found with the URI part " + path));

        Class<? extends ActionCommand> commandClass = actionRepository.getActionCommands().stream()
                .filter(a -> DescribeActionService.getTypeArguments(a)[1].equals(action))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No action command for the action " + action.getName() + " was found"));

        Type[] types = DescribeActionService.getTypeArguments(commandClass);

        try {
            Object inputObject = Class.forName(types[2].getTypeName()).newInstance();

            if (serviceRequest.hasInputs()) {
                for (Field field : findInputFields(types[2])) {
                    Action.Input annotation = field.getAnnotation(Action.Input.class);

                    Optional<EngineValue> optional = serviceRequest.getInputs().stream()
                            .filter(i -> i.getDeveloperName().equals(annotation.name()))
                            .findFirst();

                    optional.ifPresent(input -> valueParser.populateObjectField(inputObject, field, annotation.contentType(), input));
                }
            }

            List<Field> outputFields = findOutputFields(types[3]);

            String authorization = authorizationEncoder.encode(authenticatedWhoProvider.get());
            ActionCommand command = injector.getInstance(commandClass);

            ActionResponse actionResponse = executeAction(command, serviceRequest, inputObject, outputFields, authorization);

            if (!outputFields.isEmpty() && actionResponse.getOutputs() == null && !actionResponse.getInvokeType().equals(InvokeType.Wait)) {
                throw new RuntimeException("The action response is expecting one or more outputs");
            }

            List<EngineValue> outputs = Lists.newArrayList();

            if (actionResponse.getOutputs() != null) {
                outputs = outputFields.stream()
                        .map(output -> createOutputValue(actionResponse.getOutputs(), output))
                        .collect(Collectors.toList());
            }

            return new ServiceResponse(actionResponse.getInvokeType(), outputs, serviceRequest.getToken(), actionResponse.getWaitMessage());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException("Unable to execute the message action for the path " + path, e);
        }
    }

    ActionResponse executeAction(ActionCommand command, ServiceRequest serviceRequest, Object inputObject, List<Field> outputFields, String authorization) {
        Configuration configuration = configurationParser.from(serviceRequest);

        CompletableFuture<ActionResponse> future = CompletableFuture
                .supplyAsync(() -> command.execute(configuration, serviceRequest, inputObject), executor);

        long startTime = System.currentTimeMillis();

        while (true) {
            long elapsedTime = System.currentTimeMillis() - startTime;

            // If the action is done, then return the result straight away, synchronously
            if (future.isDone()) {
                return future.getNow(null);
            }

            // If the action is taking longer than 10 seconds, upgrade it to an asynchronous one
            if (elapsedTime > 10000) {
                // Tell the future to call back to ManyWho with the result asynchronously when done
                future.whenCompleteAsync((actionResponse, throwable) -> {
                    List<EngineValue> outputs = Lists.newArrayList();

                    if (actionResponse.getOutputs() != null) {
                        outputs = outputFields.stream()
                                .map(output -> createOutputValue(actionResponse.getOutputs(), output))
                                .collect(Collectors.toList());
                    }

                    ServiceResponse serviceResponse = new ServiceResponse();
                    serviceResponse.setInvokeType(actionResponse.getInvokeType());
                    serviceResponse.setOutputs(outputs);
                    serviceResponse.setTenantId(serviceRequest.getTenantId());
                    serviceResponse.setToken(serviceRequest.getToken());
                    serviceResponse.setWaitMessage(actionResponse.getWaitMessage());

                    LOGGER.info("Calling back to ManyWho for the action with the token {}", serviceRequest.getToken());

                    // Call back to ManyWho with the result
                    runClient.callback(authorization, serviceRequest.getTenantId(), serviceResponse).enqueue(new Callback<InvokeType>() {
                        @Override
                        public void onResponse(Call<InvokeType> call, Response<InvokeType> response) {
                            if (!response.isSuccessful()) {
                                LOGGER.error("Unable to send a callback to ManyWho for the token {}. The response status was: {}", serviceRequest.getToken(), response.message());
                            }
                        }

                        @Override
                        public void onFailure(Call<InvokeType> call, Throwable t) {
                            LOGGER.error("Unable to send a callback to ManyWho for the token {}. The errorc was: {}", serviceRequest.getToken(), t.getMessage());
                        }
                    });
                });

                // And return a WAIT response synchronously
                return new ActionResponse(InvokeType.Wait, "Waiting for an action to complete");
            }

            try {
                // Force a context switch to keep responsiveness (this feels wrong)
                Thread.sleep(0);
            } catch (InterruptedException e) {
                LOGGER.error("Unable to sleep the thread", e);
            }
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

    private EngineValue createOutputValue(Object outputs, Field field) {
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
