package com.manywho.sdk.services.describe.actions;

import com.manywho.sdk.entities.describe.DescribeServiceActionOutcomeCollection;
import com.manywho.sdk.entities.describe.DescribeValueCollection;

public class DefaultAction implements Action {
    private String uriPart;
    private String developerName;
    private String developerSummary;
    private DescribeValueCollection inputs;
    private DescribeValueCollection outputs;

    public DefaultAction(String uriPart, String developerName, String developerSummary, DescribeValueCollection inputs, DescribeValueCollection outputs) {
        this.uriPart = uriPart;
        this.developerName = developerName;
        this.developerSummary = developerSummary;
        this.inputs = inputs;
        this.outputs = outputs;
    }

    @Override
    public String getUriPart() {
        return uriPart;
    }

    @Override
    public String getDeveloperName() {
        return developerName;
    }

    @Override
    public String getDeveloperSummary() {
        return developerSummary;
    }

    @Override
    public DescribeServiceActionOutcomeCollection getServiceActionOutcomes() {
        return null;
    }

    @Override
    public DescribeValueCollection getServiceInputs() {
        return inputs;
    }

    @Override
    public DescribeValueCollection getServiceOutputs() {
        return outputs;
    }

    @Override
    public boolean isViewMessageAction() {
        return false;
    }

    @Override
    public int compareTo(Action action) {
        return this.getDeveloperName().compareTo(action.getDeveloperName());
    }
}
