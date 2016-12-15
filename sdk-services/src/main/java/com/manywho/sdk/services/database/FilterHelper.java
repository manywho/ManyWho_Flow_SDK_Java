package com.manywho.sdk.services.database;

import com.manywho.sdk.services.types.Type;
import org.reflections.Reflections;

import javax.inject.Inject;
import java.lang.reflect.Field;

public class FilterHelper {
    private final Reflections reflections;

    @Inject
    public FilterHelper(Reflections reflections) {
        this.reflections = reflections;
    }

    /**
     * Find the field name of a defined property on a Type, by the property name.
     *
     * @param type         The ManyWho type in which to look for the property
     * @param propertyName The name of the property defined in the ManyWho type to query by
     * @return the name of the field that matched the property.
     */
    public String findFieldName(Class<? extends Type> type, String propertyName) {
        return reflections.getFieldsAnnotatedWith(Type.Property.class).stream()
                .filter(field -> field.getDeclaringClass().equals(type))
                .filter(field -> field.getAnnotation(Type.Property.class).name().equals(propertyName))
                .map(Field::getName)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unable to match a field to the property name " + propertyName));
    }
}
