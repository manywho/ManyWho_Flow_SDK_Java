package com.manywho.sdk.services.config;

import java.io.IOException;
import java.util.Properties;

public class ServiceConfigurationProperties implements ServiceConfiguration {
    protected Properties properties;

    public ServiceConfigurationProperties() {
        try {
            properties = new Properties();
            properties.load(getClass().getClassLoader().getResourceAsStream("service.properties"));
        } catch (IOException exception) {
            properties = new Properties();
        }
    }

    @Override
    public String get(String key) {
        return properties.getProperty(key);
    }
}
