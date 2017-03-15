package com.manywho.sdk.services.functional.functional.actions;

import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.services.actions.ActionCommand;
import com.manywho.sdk.services.actions.ActionResponse;
import com.manywho.sdk.services.functional.functional.TestApplicationConfiguration;

public class TestActionCommand implements ActionCommand<TestApplicationConfiguration, TestAction, TestAction, TestAction> {

    @Override
    public ActionResponse<TestAction> execute(TestApplicationConfiguration configuration, ServiceRequest request, TestAction input) {
        return new ActionResponse<TestAction>(input, InvokeType.Forward);
    }
}
