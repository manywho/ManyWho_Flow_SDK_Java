package com.manywho.sdk.services.health;

public interface HealthHandler {
    /**
     * Determines if the service and all of its required are healthy or not.
     *
     * @return whether the service is considered healthy
     */
    boolean isHealthy();
}
