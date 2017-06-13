package com.manywho.sdk.api.describe;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class DescribeServiceActionResponse extends DescribeServiceActionRequest {
    private String developerName;
    private String developerSummary;
    private List<DescribeUIServiceActionOutcome> serviceActionOutcomes = Lists.newArrayList();
    @JsonProperty("isViewMessageAction")
    private boolean viewMessageAction;

    public DescribeServiceActionResponse() {
    }

    public DescribeServiceActionResponse(
            String developerName,
            String developerSummary,
            String uriPart,
            List<DescribeValue> serviceInputs,
            List<DescribeValue> serviceOutputs
    ) {
        this.developerName = developerName;
        this.developerSummary = developerSummary;
        this.uriPart = uriPart;
        this.serviceInputs = serviceInputs;
        this.serviceOutputs = serviceOutputs;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getDeveloperSummary() {
        return developerSummary;
    }

    public void setDeveloperSummary(String developerSummary) {
        this.developerSummary = developerSummary;
    }

    public List<DescribeUIServiceActionOutcome> getServiceActionOutcomes() {
        return serviceActionOutcomes;
    }

    public void setServiceActionOutcomes(List<DescribeUIServiceActionOutcome> serviceActionOutcomes) {
        this.serviceActionOutcomes = MoreObjects.firstNonNull(serviceActionOutcomes, new ArrayList<DescribeUIServiceActionOutcome>());
    }

    public boolean isViewMessageAction() {
        return viewMessageAction;
    }

    public void setViewMessageAction(boolean viewMessageAction) {
        this.viewMessageAction = viewMessageAction;
    }
}
