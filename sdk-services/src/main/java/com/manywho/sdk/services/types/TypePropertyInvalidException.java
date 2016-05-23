package com.manywho.sdk.services.types;

public class TypePropertyInvalidException extends RuntimeException {
    public TypePropertyInvalidException(String property, String type) {
        super("The value of property " + property + " is not a valid " + type);
    }
}
