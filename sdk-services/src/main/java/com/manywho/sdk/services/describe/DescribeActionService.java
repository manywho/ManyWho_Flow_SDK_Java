package com.manywho.sdk.services.describe;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.describe.DescribeServiceActionResponse;
import com.manywho.sdk.api.describe.DescribeValue;
import com.manywho.sdk.services.actions.Action;
import com.manywho.sdk.services.actions.ActionCommand;
import com.manywho.sdk.services.types.TypeParser;
import org.reflections.Reflections;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DescribeActionService {
    private final Reflections reflections;

    @Inject
    public DescribeActionService(Reflections reflections) {
        this.reflections = reflections;
    }

    public List<DescribeServiceActionResponse> createActions() {
        final Set<Class<?>> actions = reflections.getTypesAnnotatedWith(Action.Metadata.class);

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

        Class<? extends ActionCommand> command = reflections.getSubTypesOf(ActionCommand.class).stream()
                .filter(a -> getTypeArguments(a)[0].equals(action))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No action command for the action " + action.getName() + " was found"));

        Type[] types = getTypeArguments(command);

        List<DescribeValue> inputs = reflections.getFieldsAnnotatedWith(Action.Input.class).stream()
                .filter(input -> input.getDeclaringClass().equals(types[1]))
                .map(this::createInput)
                .collect(Collectors.toList());

        List<DescribeValue> outputs = reflections.getFieldsAnnotatedWith(Action.Output.class).stream()
                .filter(input -> input.getDeclaringClass().equals(types[2]))
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

        if (pType.getActualTypeArguments().length != 3) {
            throw new RuntimeException("The generic type argument for " + type.getName() + " must have three type arguments");
        }

        return pType.getActualTypeArguments();
    }
}
