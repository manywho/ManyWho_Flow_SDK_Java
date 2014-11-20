package com.manywho.sdk.services.describe.actions;

import com.manywho.sdk.entities.describe.DescribeServiceActionOutcomeCollection;

public abstract class AbstractAction implements Action {
    @Override
    public DescribeServiceActionOutcomeCollection getServiceActionOutcomes() {
        return null;
    }

    @Override
    public boolean isViewMessageAction() {
        return false;
    }
}
