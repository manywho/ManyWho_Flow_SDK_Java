package com.manywho.sdk.services.describe.actions;

import com.manywho.sdk.entities.describe.DescribeServiceActionOutcomeCollection;
import com.manywho.sdk.entities.describe.DescribeValueCollection;

public interface Action {
    public String getUriPart();

    public String getDeveloperName();

    public String getDeveloperSummary();

    public DescribeServiceActionOutcomeCollection getServiceActionOutcomes();

    public DescribeValueCollection getServiceInputs();

    public DescribeValueCollection getServiceOutputs();

    public boolean isViewMessageAction();
}
