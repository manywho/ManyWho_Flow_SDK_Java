package com.manywho.sdk.services.types;

import com.manywho.sdk.api.ContentType;

import java.lang.reflect.Field;

public class TypePropertyMismatchException extends RuntimeException {
    public TypePropertyMismatchException(Field field, Class<?> expectedType, ContentType contentType) {
        super("The field " + field.getName() + " is not a " + expectedType.getName() + ", but it has a @" + Type.Property.class.getCanonicalName() + " annotation with a content type of " + contentType);
    }
}
