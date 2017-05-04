package com.manywho.sdk.services.actions;

import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.api.run.elements.config.ServiceResponse;
import com.manywho.sdk.services.configuration.Configuration;

public interface ActionHandler<C extends Configuration> {
    Boolean canHandleAction(String path, C configuration, ServiceRequest serviceRequest);
    ServiceResponse handleRaw(String path, C configuration, ServiceRequest serviceRequest);
}
