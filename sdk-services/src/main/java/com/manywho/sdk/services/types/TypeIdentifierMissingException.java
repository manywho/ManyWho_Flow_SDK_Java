package com.manywho.sdk.services.types;

public class TypeIdentifierMissingException extends RuntimeException {
    public TypeIdentifierMissingException(Class<? extends Type> type) {
        super("The type " + type.getName() + " must contain a single String property annotated with " + Type.Identifier.class.getCanonicalName());
    }
}
