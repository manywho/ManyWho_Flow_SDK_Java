package com.manywho.sdk.services.describe;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.describe.DescribeServiceActionResponse;
import com.manywho.sdk.api.describe.DescribeValue;
import com.manywho.sdk.services.actions.Action;
import com.manywho.sdk.services.actions.ActionCommand;
import com.manywho.sdk.services.actions.ActionCommandNotFoundException;
import com.manywho.sdk.services.actions.ActionRepository;
import com.manywho.sdk.services.types.TypeParser;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DescribeActionService {
    private final ActionRepository actionRepository;

    private static final int ACTION_COMMAND_TYPE_ACTION = 1;
    private static final int ACTION_COMMAND_TYPE_INPUT = 2;
    private static final int ACTION_COMMAND_TYPE_OUTPUT = 3;

    @Inject
    public DescribeActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public List<DescribeServiceActionResponse> createActions() {
        final Set<Class<?>> actions = actionRepository.getActions();

        if (actions.isEmpty()) {
            return Lists.newArrayList();
        }

        // Create the actions
        return actions.stream()
                .map(this::createDescribeServiceActionResponse)
                .collect(Collectors.toList());
    }

    private DescribeServiceActionResponse createDescribeServiceActionResponse(Class<?> action) {
        if (!action.isAnnotationPresent(Action.Metadata.class)) {
            throw new RuntimeException("The action " + action.getName() + " must be annotated with " + Action.Metadata.class.getCanonicalName());
        }

        Class<? extends ActionCommand> command = actionRepository.getActionCommands().stream()
                .filter(a -> getTypeArguments(a)[ACTION_COMMAND_TYPE_ACTION].equals(action))
                .findFirst()
                .orElseThrow(() -> new ActionCommandNotFoundException(action));

        Type[] types = getTypeArguments(command);

        List<DescribeValue> inputs = actionRepository.getInputFields().stream()
                .filter(input -> input.getDeclaringClass().equals(types[ACTION_COMMAND_TYPE_INPUT]))
                .map(this::createInput)
                .collect(Collectors.toList());

        List<DescribeValue> outputs = actionRepository.getOutputFields().stream()
                .filter(input -> input.getDeclaringClass().equals(types[ACTION_COMMAND_TYPE_OUTPUT]))
                .map(this::createOutput)
                .collect(Collectors.toList());

        Action.Metadata metadata = action.getAnnotation(Action.Metadata.class);

        return new DescribeServiceActionResponse(metadata.name(), metadata.summary(), "actions/" + metadata.uri(), inputs, outputs);
    }

    private DescribeValue createOutput(Field field) {
        Action.Output output = field.getAnnotation(Action.Output.class);

        return createDescribeValue(field, output.name(), output.contentType(), output.required());
    }

    private DescribeValue createInput(Field field) {
        Action.Input input = field.getAnnotation(Action.Input.class);

        return createDescribeValue(field, input.name(), input.contentType(), input.required());
    }

    private DescribeValue createDescribeValue(Field field, String name, ContentType contentType, boolean required) {
        String referencedTypeName = null;

        // If the input annotation is of type Object or List, then we need to find the typeElementName of the referenced type
        if (contentType.equals(ContentType.List) || contentType.equals(ContentType.Object)) {
            referencedTypeName = TypeParser.getReferencedTypeName(field, contentType);
        }

        return new DescribeValue(name, contentType, required, referencedTypeName);
    }

    public static Type[] getTypeArguments(Class<?> type) {
        if (type.getGenericInterfaces().length != 1) {
            throw new RuntimeException(type.getName() + " must have a generic type argument");
        }

        ParameterizedType pType = (ParameterizedType)type.getGenericInterfaces()[0];

        if (pType.getActualTypeArguments().length != 4) {
            throw new RuntimeException("The generic type argument for " + type.getName() + " must have four type arguments");
        }

        return pType.getActualTypeArguments();
    }
}
