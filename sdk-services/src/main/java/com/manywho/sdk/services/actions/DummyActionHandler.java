package com.manywho.sdk.services.actions;

import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.api.run.elements.config.ServiceResponse;
import com.manywho.sdk.services.configuration.Configuration;

public class DummyActionHandler implements ActionHandler {
    @Override
    public Boolean canHandleAction(String path, Configuration configuration, ServiceRequest serviceRequest) {
        return false;
    }

    @Override
    public ServiceResponse handleRaw(String path, Configuration configuration, ServiceRequest serviceRequest) {
        return null;
    }
}
