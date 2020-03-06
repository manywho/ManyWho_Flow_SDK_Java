package com.manywho.sdk.api.draw.elements.group;

import com.manywho.sdk.api.draw.elements.value.ValueElementId;

public class GroupAuthorizationLocation {
    private String developerName;
    private String developerSummary;
    private ValueElementId valueElementToReferenceId;
    private String attribute;

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

    public ValueElementId getValueElementToReferenceId() {
        return valueElementToReferenceId;
    }

    public void setValueElementToReferenceId(ValueElementId valueElementToReferenceId) {
        this.valueElementToReferenceId = valueElementToReferenceId;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
