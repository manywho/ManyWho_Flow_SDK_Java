package com.manywho.sdk.services.unit.entities;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

@Type.Element(name = TestType.NAME)
public class TestType implements Type {
    public static final String NAME = "Test Type";

    @Type.Identifier
    private String id;

    @Type.Property(name = "Name", contentType = ContentType.String)
    private String name;
}
