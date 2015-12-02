package com.manywho.sdk.services.config;

public interface ServiceConfiguration {
    String get(String key);
    boolean has(String key);
}
