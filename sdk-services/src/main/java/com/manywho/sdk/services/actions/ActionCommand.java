package com.manywho.sdk.services.actions;

import com.manywho.sdk.api.run.elements.config.ServiceRequest;

public interface ActionCommand<C, A, I, O> {
    ActionResponse<O> execute(C configuration, ServiceRequest request, I input);
}
