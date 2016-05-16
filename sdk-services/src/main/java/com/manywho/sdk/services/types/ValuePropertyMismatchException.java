package com.manywho.sdk.services.types;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.values.Value;

import java.lang.reflect.Field;

public class ValuePropertyMismatchException extends RuntimeException {
    public ValuePropertyMismatchException(Field field, Class<?> expectedType, ContentType contentType) {
        super("The field " + field.getName() + " is not a " + expectedType.getName() + ", but it has a @" + Value.Property.class.getCanonicalName() + " annotation with a content type of " + contentType);
    }
}
