package com.manywho.sdk.services.unit.entities;

import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.services.actions.ActionCommand;
import com.manywho.sdk.services.actions.ActionResponse;

public class TestActionCommand implements ActionCommand<TestConfigurationSettings, TestAction, TestAction, TestAction> {
    @Override
    public ActionResponse<TestAction> execute(TestConfigurationSettings configuration, ServiceRequest request, TestAction input) {
        return null;
    }
}
