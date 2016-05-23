package com.manywho.sdk.services.unit.entities;

import com.manywho.sdk.services.actions.ActionCommand;
import com.manywho.sdk.services.actions.ActionResponse;

public class TestActionCommand implements ActionCommand<TestAction, TestAction, TestAction> {
    @Override
    public ActionResponse<TestAction> execute(TestAction input) {
        return null;
    }
}
