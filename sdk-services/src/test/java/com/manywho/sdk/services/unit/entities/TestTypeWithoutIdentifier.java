package com.manywho.sdk.services.unit.entities;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

@Type.Element(name = TestTypeWithoutIdentifier.NAME)
public class TestTypeWithoutIdentifier implements Type {
    static final String NAME = "Type Without Identifier";

    @Type.Property(name = "Name", contentType = ContentType.String)
    private String name;
}
