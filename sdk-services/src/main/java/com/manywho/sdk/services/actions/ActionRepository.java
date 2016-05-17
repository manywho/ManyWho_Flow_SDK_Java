package com.manywho.sdk.services.actions;

import org.reflections.Reflections;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Field;
import java.util.Set;

@Singleton
public class ActionRepository {
    private final Reflections reflections;

    private Set<Class<?>> actions;
    private Set<Class<? extends ActionCommand>> actionCommands;
    private Set<Field> inputFields;
    private Set<Field> outputFields;

    @Inject
    public ActionRepository(Reflections reflections) {
        this.reflections = reflections;
    }

    public Set<Class<?>> getActions() {
        if (actions == null) {
            actions = reflections.getTypesAnnotatedWith(Action.Metadata.class);
        }

        return actions;
    }

    public Set<Class<? extends ActionCommand>> getActionCommands() {
        if (actionCommands == null) {
            actionCommands = reflections.getSubTypesOf(ActionCommand.class);
        }

        return actionCommands;
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
