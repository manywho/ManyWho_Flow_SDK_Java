package com.manywho.sdk.services.exceptions;

import com.manywho.sdk.enums.ContentType;

public class MissingTypeReferenceException extends Exception {
    public MissingTypeReferenceException(String typeName, ContentType contentType) {
        super(String.format("The @TypeProperty %s is of type %s but does not have a referenceType() set", typeName, contentType));
    }
}
