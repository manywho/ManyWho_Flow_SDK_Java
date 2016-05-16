package com.manywho.sdk.services.types;

public class TypeElementMissingException extends RuntimeException {
    public TypeElementMissingException(Class<?> klass) {
        super("The " + klass + " is not a valid Type Element. It must be annotated with " + Type.Element.class.getName() + ".");
    }
}
