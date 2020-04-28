package com.manywho.sdk.services.functional.functional.types;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

import java.util.List;

@Type.Element(name = "Test Type")
public class TestType implements Type {
    @Type.Identifier
    private String id;

    @Type.Property(name = "Name", contentType = ContentType.String)
    private String name;

    @Type.Property(name = "Twos", contentType = ContentType.List)
    private List<TestTypeTwo> twos;
}
