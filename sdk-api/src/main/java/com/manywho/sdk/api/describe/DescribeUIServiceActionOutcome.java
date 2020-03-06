package com.manywho.sdk.api.describe;

import java.util.UUID;

public class DescribeUIServiceActionOutcome {
    private UUID id;
    private String developerName;
    private String developerSummary;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
}
