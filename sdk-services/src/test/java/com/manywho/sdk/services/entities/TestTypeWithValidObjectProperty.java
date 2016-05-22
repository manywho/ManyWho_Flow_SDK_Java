package com.manywho.sdk.services.entities;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

@Type.Element(name = TestTypeWithValidObjectProperty.NAME)
public class TestTypeWithValidObjectProperty implements Type {
    public static final String NAME = "Valid Object";

    @Identifier
    private String id;

    @Property(name = "Name", contentType = ContentType.String)
    private String name;
}
