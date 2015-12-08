package com.manywho.sdk.services.actions;

import com.manywho.sdk.entities.run.EngineValue;
import com.manywho.sdk.entities.run.EngineValueCollection;
import com.manywho.sdk.services.annotations.ActionInput;
import com.manywho.sdk.services.annotations.TypeElement;
import com.manywho.sdk.services.types.TypeParser;
import com.manywho.sdk.utils.ValidationUtils;
import org.reflections.Reflections;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ActionParser {
    private Reflections reflections;
    private TypeParser typeParser;

    @Inject
    public ActionParser(Reflections reflections, TypeParser typeParser) {
        this.reflections = reflections;
        this.typeParser = typeParser;
    }

    public <T> T parseInputs(EngineValueCollection inputs, Class<T> tClass) throws Exception {
        Set<ActionInputFieldTuple> tuples = reflections.getFieldsAnnotatedWith(ActionInput.class).stream()
                .filter(field -> field.getDeclaringClass().equals(tClass))
                .map(field -> new ActionInputFieldTuple(field.getAnnotation(ActionInput.class), field))
                .collect(Collectors.toSet());

        T actionObject = tClass.newInstance();

        if (tuples.isEmpty()) {
            return actionObject;
        }

        for (ActionInputFieldTuple tuple : tuples) {
            Optional<EngineValue> value = inputs.stream()
                    .filter(engineValue -> engineValue.getDeveloperName().equals(tuple.getInput().name()))
                    .findFirst();

            if (value.isPresent()) {
                tuple.getField().setAccessible(true);
                tuple.getField().set(actionObject, this.createFieldValue(value.get(), tuple));
            }
        }

        ValidationUtils.validate(actionObject);

        return actionObject;
    }

    private Object createFieldValue(EngineValue engineValue, ActionInputFieldTuple tuple) throws Exception {
        Field field = tuple.getField();

        switch (tuple.getInput().contentType()) {
            case Object:
                return this.getObjectFieldValue(engineValue, field);
            case List:
                return this.getListFieldValue(engineValue, field, tuple.getInput().name());
            default:
                return engineValue.getContentValue();
        }
    }

    private Object getObjectFieldValue(EngineValue engineValue, Field field) throws Exception {
        return typeParser.parseObject(engineValue.getObjectData().get(0), field.getType());
    }

    private Object getListFieldValue(EngineValue engineValue, Field field, String name) throws Exception {
        String typeElementName = field.getType().getAnnotation(TypeElement.class).name();

        // Find the type of the list's generic
        Class<?> listType = TypeParser.getListPropertyGenericType(typeElementName, field, name);

        return typeParser.parseList(engineValue.getObjectData(), listType);
    }
}
