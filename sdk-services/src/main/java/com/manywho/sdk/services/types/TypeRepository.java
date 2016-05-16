package com.manywho.sdk.services.types;

import org.reflections.Reflections;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.Set;

public class TypeRepository {
    private final Reflections reflections;

    private Set<Field> typeIdentifiers;

    @Inject
    public TypeRepository(Reflections reflections) {
        this.reflections = reflections;
    }

    public Set<Field> getTypeIdentifiers() {
        if (typeIdentifiers == null) {
            typeIdentifiers = reflections.getFieldsAnnotatedWith(Type.Identifier.class);
        }

        return typeIdentifiers;
    }

    public Field findTypeIdentifier(Class<? extends Type> type) {
        return getTypeIdentifiers().stream()
                .filter(field -> field.getDeclaringClass().equals(type))
                .findFirst()
                .orElseThrow(() -> new TypeIdentifierMissingException(type));
    }
}
