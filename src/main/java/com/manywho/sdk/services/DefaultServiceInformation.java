package com.manywho.sdk.services;

public class DefaultServiceInformation implements ServiceInformation {
    @Override
    public String getServiceName() {
        return "Unknown";
    }

    @Override
    public String getServicePackage() {
        return "com.manywho.services.unknown";
    }
}
