package com.manywho.sdk.services.functional.actions;

import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.services.actions.ActionCommand;
import com.manywho.sdk.services.actions.ActionResponse;

public class TestActionCommand implements ActionCommand<TestAction, TestAction, TestAction> {
    @Override
    public ActionResponse<TestAction> execute(TestAction input) {
        return new ActionResponse<TestAction>(input, InvokeType.Forward);
    }
}
