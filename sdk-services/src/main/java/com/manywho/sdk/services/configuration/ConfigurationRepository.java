package com.manywho.sdk.services.configuration;

import org.reflections.Reflections;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.stream.Collectors;

public class ConfigurationRepository {
    private final Reflections reflections;

    private Set<Field> configurationValues;

    @Inject
    public ConfigurationRepository(Reflections reflections) {
        this.reflections = reflections;
    }

    public Class<? extends Configuration> getConfigurationClass() {
        Set<Class<? extends Configuration>> configurationClasses = reflections.getSubTypesOf(Configuration.class);

        if (configurationClasses.isEmpty()) {
            throw new RuntimeException("No class implementing " + Configuration.class.getCanonicalName() + " was found");
        }

        if (configurationClasses.size() > 1) {
            throw new RuntimeException("More than one class implementing " + Configuration.class.getCanonicalName() + " was found - only a single implementation is currently supported");
        }

        return configurationClasses.iterator().next();
    }

    public Set<Field> getConfigurationValues() {
        if (configurationValues == null) {
            configurationValues = reflections.getFieldsAnnotatedWith(Configuration.Value.class);
        }

        return configurationValues;
    }

    public Set<Field> findConfigurationValues(Class<?> configurationClass) {
        return getConfigurationValues().stream()
                .filter(annotation -> annotation.getDeclaringClass().equals(configurationClass))
                .collect(Collectors.toSet());
    }
}
