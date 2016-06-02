package com.manywho.sdk.services.actions;

import com.manywho.sdk.api.run.elements.config.ServiceRequest;

public interface ActionCommand<A, I, O, C> {
    ActionResponse<O> execute(C configuration, ServiceRequest request, I input);
}
