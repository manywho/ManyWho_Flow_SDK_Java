package com.manywho.sdk.services.health;

import org.reflections.Reflections;

import javax.inject.Inject;
import java.util.Set;
import java.util.stream.Collectors;

public class HealthRepository {
    private final Reflections reflections;

    @Inject
    public HealthRepository(Reflections reflections) {
        this.reflections = reflections;
    }

    public Class<? extends HealthHandler> getHealthHandler() {
        Set<Class<? extends HealthHandler>> handlers = reflections.getSubTypesOf(HealthHandler.class)
                .stream()
                .filter(subType -> subType.getPackage().getName().startsWith("com.manywho.sdk.services") == false)
                .collect(Collectors.toSet());

        if (handlers.isEmpty()) {
            return DummyHealthHandler.class;
        }

        if (handlers.size() > 1) {
            throw new RuntimeException("Your service may only have one health handler implementation");
        }

        return handlers.iterator().next();
    }
}
