package com.manywho.sdk.services.types;

import com.manywho.sdk.api.ContentType;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

public class TypeParser {
    public static Class<?> findGenericType(java.lang.reflect.Type type, int index) {
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;

            return (Class<?>) parameterizedType.getActualTypeArguments()[index];
        }

        throw new RuntimeException(String.format("The given type %s is not a generic type", type));
    }

    public static String getReferencedTypeName(Field property, ContentType contentType) {
        Class<?> referencedType = null;

        // If the property is a ContentList, then we need to find the generic type of the Collection
        if (contentType.equals(ContentType.List)) {
            if (Collection.class.isAssignableFrom(property.getType())) {
                referencedType = findGenericType(property.getGenericType(), 0);
            } else {
                throw new RuntimeException("The Element Property " + property + " is a ContentList but does not have a type that inherits " + Collection.class);
            }
        }

        // If the property is a ContentObject, then we need just need to get the type of the field
        if (contentType.equals(ContentType.Object)) {
            referencedType = property.getType();
        }

        if (referencedType == null) {
            throw new RuntimeException("Unable to find the referenced type for " + property);
        }

        // If the referenced type implements the Type interface and is annotated with @Type.Element then return the name
        if (Type.class.isAssignableFrom(referencedType) && referencedType.isAnnotationPresent(Type.Element.class)) {
            return referencedType.getAnnotation(Type.Element.class).name();
        }

        throw new TypeElementMissingException(referencedType);
    }
}
