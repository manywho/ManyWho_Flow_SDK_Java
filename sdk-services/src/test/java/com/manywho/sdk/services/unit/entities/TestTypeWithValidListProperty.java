package com.manywho.sdk.services.unit.entities;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

import java.util.List;

@Type.Element(name = TestTypeWithValidListProperty.NAME, summary = TestTypeWithValidListProperty.SUMMARY)
public class TestTypeWithValidListProperty implements Type {
    public static final String NAME = "Valid List";
    public static final String SUMMARY = "A valid summary";

    @Identifier
    private String id;

    @Property(name = "Valid Objects", contentType = ContentType.List)
    private List<TestTypeWithValidObjectProperty> validObjects;
}
