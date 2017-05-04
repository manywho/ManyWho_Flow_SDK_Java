package com.manywho.services.example.actions;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.api.run.elements.config.ServiceResponse;
import com.manywho.sdk.services.actions.ActionHandler;
import com.manywho.sdk.services.configuration.Configuration;

import java.util.List;

public class RawActionHandler implements ActionHandler {
    @Override
    public boolean canHandleAction(String uriPath, Configuration configuration, ServiceRequest serviceRequest) {
        return uriPath == "custom-action";
    }

    @Override
    public ServiceResponse handleRaw(String s, Configuration configuration, ServiceRequest serviceRequest) {
        List<EngineValue> serviceInputs = serviceRequest.getInputs();

        List<EngineValue> outputs = Lists.newArrayList();
        EngineValue engineValue1 = new EngineValue("Output 1", ContentType.String, "Value1");
        outputs.add(engineValue1);

        return new ServiceResponse(InvokeType.Forward, outputs, serviceRequest.getToken());
    }
}
