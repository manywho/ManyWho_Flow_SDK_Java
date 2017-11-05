package com.manywho.sdk.services.types;

import com.manywho.sdk.services.utils.Fields;
import org.reflections.Reflections;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TypeRepository {
    private final Reflections reflections;

    private Set<Class<? extends Type>> typeElements;
    private Set<Field> typeIdentifiers;
    private Set<Field> typeProperties;

    @Inject
    public TypeRepository(Reflections reflections) {
        this.reflections = reflections;
    }

    public Class<? extends Type> findTypeElement(String name) {
        return getTypeElements().stream()
                .filter(typeElement -> typeElement.getAnnotation(Type.Element.class).name().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("A type element could not be found with the name " + name));
    }

    public Field findTypeIdentifier(Class<? extends Type> type) {
        List<Field> typeFields = Fields.fromType(type);

        return getTypeIdentifiers().stream()
                .filter(field -> typeFields.contains(field))
                .findFirst()
                .orElseThrow(() -> new TypeIdentifierMissingException(type));
    }

    public Map<String, Field> findTypeProperties(Class<?> type) {
        List<Field> typeFields = Fields.fromType(type);

        return getTypeProperties().stream()
                .filter(typeFields::contains)
                .collect(Collectors.toMap(
                        field -> field.getAnnotation(Type.Property.class).name(),
                        field -> field
                ));
    }

    public Set<Class<? extends Type>> getTypeElements() {
        if (typeElements == null) {
            typeElements = reflections.getSubTypesOf(Type.class);
        }

        return typeElements;
    }

    public Set<Field> getTypeIdentifiers() {
        if (typeIdentifiers == null) {
            typeIdentifiers = reflections.getFieldsAnnotatedWith(Type.Identifier.class);
        }

        return typeIdentifiers;
    }

    public Set<Field> getTypeProperties() {
        if (typeProperties == null) {
            typeProperties = reflections.getFieldsAnnotatedWith(Type.Property.class);
        }

        return typeProperties;
    }
}
