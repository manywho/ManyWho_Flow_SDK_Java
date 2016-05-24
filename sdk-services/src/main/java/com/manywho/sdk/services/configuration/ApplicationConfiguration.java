package com.manywho.sdk.services.configuration;

public class ApplicationConfiguration {
    private final String applicationPackage;

    public ApplicationConfiguration(String applicationPackage) {
        this.applicationPackage = applicationPackage;
    }

    public String getApplicationPackage() {
        return applicationPackage;
    }
}
