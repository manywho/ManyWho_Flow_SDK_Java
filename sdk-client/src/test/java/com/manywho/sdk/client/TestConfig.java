package com.manywho.sdk.client;

import com.google.common.io.Resources;

import java.io.IOException;
import java.util.Properties;

final class TestConfig {
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            properties.load(Resources.getResource("config.properties").openStream());
        } catch (IOException exception) {
            throw new IllegalStateException("Couldn't open \"src/test/resources/config.properties", exception);
        }
    }

    public static String getTenantId() {
        return "72236525-545d-4927-bb53-37a58a79178e";
    }
}
