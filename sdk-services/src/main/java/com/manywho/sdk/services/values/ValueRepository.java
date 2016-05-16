package com.manywho.sdk.services.values;

import org.reflections.Reflections;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ValueRepository {
    private final Reflections reflections;

    private Set<Field> typeProperties;

    @Inject
    public ValueRepository(Reflections reflections) {
        this.reflections = reflections;
    }

    public Set<Field> getTypeProperties() {
        if (typeProperties == null) {
            typeProperties = reflections.getFieldsAnnotatedWith(Value.Property.class);
        }

        return typeProperties;
    }

    public Map<String, Field> findTypeProperties(Class<?> type) {
        return getTypeProperties().stream()
                .filter(field -> field.getDeclaringClass().equals(type))
                .collect(Collectors.toMap(
                        field -> field.getAnnotation(Value.Property.class).name(),
                        field -> field
                ));
    }
}
