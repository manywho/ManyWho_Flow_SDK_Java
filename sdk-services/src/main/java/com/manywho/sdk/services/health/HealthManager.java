package com.manywho.sdk.services.health;

import javax.inject.Inject;

public class HealthManager {
    private final HealthRepository repository;
    private final HealthHandlerService service;

    @Inject
    public HealthManager(HealthRepository repository, HealthHandlerService service) {
        this.repository = repository;
        this.service = service;
    }

    public boolean isHealthy() {
        // Execute the health check handler
        return service.createHealthHandler(repository.getHealthHandler())
                .isHealthy();
    }
}
