package com.manywho.sdk.services.health;

public class DummyHealthHandler implements HealthHandler {
    @Override
    public boolean isHealthy() {
        // Always return true, as by default we just assume the JVM running is considered healthy enough
        return true;
    }
}
