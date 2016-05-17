package com.manywho.sdk.services.describe;

import com.manywho.sdk.services.configuration.ConfigurationValue;
import org.reflections.Reflections;

import javax.inject.Inject;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Set;

public class DescribeRepository {
    private final Reflections reflections;

    private Set<Field> configurationValues;

    @Inject
    public DescribeRepository(Reflections reflections) {
        this.reflections = reflections;
    }

    public boolean doSubtypesOfExist(Class<?> type) {
        return !reflections.getSubTypesOf(type).isEmpty();
    }

    public boolean doFieldsAnnotatedWithExist(final Class<? extends Annotation> annotation) {
        return !reflections.getFieldsAnnotatedWith(annotation).isEmpty();
    }

    public Set<Field> getConfigurationValues() {
        if (configurationValues == null) {
            configurationValues = reflections.getFieldsAnnotatedWith(ConfigurationValue.class);
        }

        return configurationValues;
    }
}
