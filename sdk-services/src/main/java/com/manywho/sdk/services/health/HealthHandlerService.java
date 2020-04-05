package com.manywho.sdk.services.health;

import com.google.inject.Injector;

import javax.inject.Inject;

public class HealthHandlerService {
    private final Injector injector;

    @Inject
    public HealthHandlerService(Injector injector) {
        this.injector = injector;
    }

    HealthHandler createHealthHandler(Class<? extends HealthHandler> handlerClass) {
        return injector.getInstance(handlerClass);
    }
}
