package com.manywho.sdk.services.types;

public class TypeHasNoPropertiesException extends RuntimeException {
    public TypeHasNoPropertiesException(Type.Element type) {
        super("The " + type.name() + " type must contain at least one property.");
    }
}
