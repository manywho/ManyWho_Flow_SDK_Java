package com.manywho.services.example.actions;

import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.services.actions.ActionCommand;
import com.manywho.sdk.services.actions.ActionResponse;
import com.manywho.services.example.ServiceConfiguration;
import com.manywho.services.example.actions.AddAnnotation.Input;
import com.manywho.services.example.actions.AddAnnotation.Output;

import java.time.OffsetDateTime;

public class AddAnnotationCommand implements ActionCommand<ServiceConfiguration, AddAnnotation, Input, Output> {

    @Override
    public ActionResponse<Output> execute(ServiceConfiguration configuration, ServiceRequest request, Input input) {
        return new ActionResponse<>(new Output(OffsetDateTime.now()));
    }
}
