package com.manywho.sdk.services.health;

import org.reflections.Reflections;

import javax.inject.Inject;
import java.util.Set;

public class HealthRepository {
    private final Reflections reflections;

    @Inject
    public HealthRepository(Reflections reflections) {
        this.reflections = reflections;
    }

    public Class<? extends HealthHandler> getHealthHandler() {
        Set<Class<? extends HealthHandler>> handlers = reflections.getSubTypesOf(HealthHandler.class);

        if (handlers.isEmpty()) {
            throw new RuntimeException("No health handler implementation was found in your service");
        }

        if (handlers.size() > 1) {
            throw new RuntimeException("Your service may only have one health handler implementation");
        }

        return handlers.iterator().next();
    }
}
