package com.manywho.sdk.services.actions;

public class ActionCommandNotFoundException extends RuntimeException {
    public ActionCommandNotFoundException(Class<?> action) {
        super("No action command for the action " + action.getName() + " was found");
    }
}
