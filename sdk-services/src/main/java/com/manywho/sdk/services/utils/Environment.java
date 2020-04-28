package com.manywho.sdk.services.utils;

public class Environment {
    public static String get(String name) {
        return System.getenv(name);
    }

    public static String getRequired(String name) {
        String variable = System.getenv(name);

        if (variable == null) {
            throw new RuntimeException("No " + name + " environment variable is defined");
        }

        return variable;
    }
}
