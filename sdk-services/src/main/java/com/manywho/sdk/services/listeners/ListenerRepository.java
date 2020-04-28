package com.manywho.sdk.services.listeners;

import com.manywho.sdk.services.types.Type;
import com.manywho.sdk.services.types.TypeParser;
import org.reflections.Reflections;

import javax.inject.Inject;
import java.util.Set;

public class ListenerRepository {
    private final Reflections reflections;

    private Set<Class<? extends Listener>> listeners;

    @Inject
    public ListenerRepository(Reflections reflections) {
        this.reflections = reflections;
    }

    @SuppressWarnings("unchecked")
    public <T extends Type> Class<? extends Listener<?, T>> findListener(Class<T> type, String event) {
        if (listeners == null) {
            listeners = reflections.getSubTypesOf(Listener.class);
        }

        return (Class<? extends Listener<?, T>>) listeners.stream()
                .filter(listener -> TypeParser.findGenericType(listener.getGenericInterfaces()[0], 1).equals(type))
                .filter(listener -> listener.isAnnotationPresent(Listener.Metadata.class))
                .filter(listener -> listener.getAnnotation(Listener.Metadata.class).event().equals(event))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unable to find a listener for the event " + event));
    }
}
