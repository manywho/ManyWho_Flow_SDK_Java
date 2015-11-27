package com.manywho.sdk.services.exceptions;

public class TypePropertyNotCollectionException extends Exception {
    public TypePropertyNotCollectionException(String fieldName, String typeName) {
        super(String.format("The field %s in the type %s has a content type of ContentType.List but isn't an instance of Collection<T>", fieldName, typeName));
    }
}
