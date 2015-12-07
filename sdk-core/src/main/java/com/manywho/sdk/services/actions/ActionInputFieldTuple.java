package com.manywho.sdk.services.actions;

import com.manywho.sdk.services.annotations.ActionInput;

import java.lang.reflect.Field;

public class ActionInputFieldTuple {
    private final ActionInput input;
    private final Field field;

    public ActionInputFieldTuple(ActionInput input, Field field) {
        this.input = input;
        this.field = field;
    }

    public ActionInput getInput() {
        return input;
    }

    public Field getField() {
        return field;
    }
}
