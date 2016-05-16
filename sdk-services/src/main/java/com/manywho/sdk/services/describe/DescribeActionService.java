package com.manywho.sdk.services.describe;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.describe.DescribeServiceActionResponse;
import com.manywho.sdk.api.describe.DescribeValue;
import com.manywho.sdk.services.actions.Action;
import com.manywho.sdk.services.types.TypeParser;
import com.manywho.sdk.services.values.Value;
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
        final Set<Class<? extends Action>> actions = reflections.getSubTypesOf(Action.class);

        if (actions.isEmpty()) {
            return Lists.newArrayList();
        }

        // Create the actions
        return actions.stream()
                .map(this::createDescribeServiceActionResponse)
                .collect(Collectors.toList());
    }

    private DescribeServiceActionResponse createDescribeServiceActionResponse(Class<? extends Action> action) {
        if (!action.isAnnotationPresent(Action.Metadata.class)) {
            throw new RuntimeException("The action " + action.getName() + " must be annotated with " + Action.Metadata.class.getCanonicalName());
        }

        Action.Metadata metadata = action.getAnnotation(Action.Metadata.class);

        Type[] types = getTypeArguments(action);

        List<DescribeValue> inputs = reflections.getFieldsAnnotatedWith(Action.Input.class).stream()
                .filter(input -> input.getDeclaringClass().equals(types[0]))
                .filter(input -> input.isAnnotationPresent(Value.Property.class))
                .map(this::createInput)
                .collect(Collectors.toList());

        List<DescribeValue> outputs = reflections.getFieldsAnnotatedWith(Action.Output.class).stream()
                .filter(input -> input.getDeclaringClass().equals(types[1]))
                .filter(input -> input.isAnnotationPresent(Value.Property.class))
                .map(this::createOutput)
                .collect(Collectors.toList());

        return new DescribeServiceActionResponse(metadata.name(), metadata.summary(), "actions/" + metadata.uri(), inputs, outputs);
    }

    private DescribeValue createOutput(Field field) {
        Value.Property property = field.getAnnotation(Value.Property.class);
        Action.Output output = field.getAnnotation(Action.Output.class);

        return createDescribeValue(field, property.name(), property.contentType(), output.required());
    }

    private DescribeValue createInput(Field field) {
        Value.Property property = field.getAnnotation(Value.Property.class);
        Action.Input input = field.getAnnotation(Action.Input.class);

        return createDescribeValue(field, property.name(), property.contentType(), input.required());
    }

    private DescribeValue createDescribeValue(Field field, String name, ContentType contentType, boolean required) {
        String referencedTypeName = null;

        // If the input annotation is of type Object or List, then we need to find the typeElementName of the referenced type
        if (contentType.equals(ContentType.List) || contentType.equals(ContentType.Object)) {
            referencedTypeName = TypeParser.getReferencedTypeName(field, contentType);
        }

        return new DescribeValue(name, contentType, required, referencedTypeName);
    }

    public static Type[] getTypeArguments(Class<? extends Action> action) {
        if (action.getGenericInterfaces().length != 1) {
            throw new RuntimeException(action.getName() + " must have a generic type argument");
        }

        ParameterizedType type = (ParameterizedType)action.getGenericInterfaces()[0];

        if (type.getActualTypeArguments().length != 2) {
            throw new RuntimeException("The generic type argument for " + action.getName() + " must have two type arguments");
        }

        return type.getActualTypeArguments();
    }
}
