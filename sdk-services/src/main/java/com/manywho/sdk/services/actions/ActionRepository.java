package com.manywho.sdk.services.actions;

import org.reflections.Reflections;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Field;
import java.util.Set;

@Singleton
public class ActionRepository {
    private final Reflections reflections;

    private Set<Class<? extends Action>> actions;
    private Set<Field> inputFields;
    private Set<Field> outputFields;

    @Inject
    public ActionRepository(Reflections reflections) {
        this.reflections = reflections;
    }

    public Set<Class<? extends Action>> getActions() {
        if (actions == null) {
            actions = reflections.getSubTypesOf(Action.class);
        }

        return actions;
    }

    public Set<Field> getInputFields() {
        if (inputFields == null) {
            inputFields = reflections.getFieldsAnnotatedWith(Action.Input.class);
        }

        return inputFields;
    }

    public Set<Field> getOutputFields() {
        if (outputFields == null) {
            outputFields = reflections.getFieldsAnnotatedWith(Action.Output.class);
        }

        return outputFields;
    }
}
