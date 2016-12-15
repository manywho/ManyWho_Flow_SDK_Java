package com.manywho.sdk.services.types;

public class TypeIdentifierMissingException extends RuntimeException {
    public TypeIdentifierMissingException(Class<? extends Type> type) {
        super("The type " + type.getName() + " must contain a single String, UUID or " + Type.Identifier.Custom.class.getCanonicalName() + " property annotated with " + Type.Identifier.class.getCanonicalName());
    }
}
