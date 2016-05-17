package com.manywho.sdk.services.actions;

public interface ActionCommand<A, I, O> {
    ActionResponse<O> execute(I input);
}
