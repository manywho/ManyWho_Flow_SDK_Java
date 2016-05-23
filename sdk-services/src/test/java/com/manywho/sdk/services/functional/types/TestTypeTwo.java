package com.manywho.sdk.services.functional.types;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

@Type.Element(name = "Test Type Two", summary = "This is the second test type")
public class TestTypeTwo implements Type {
    @Type.Identifier
    private String id;

    @Type.Property(name = "Age", contentType = ContentType.Number, bound = false)
    private Integer age;
}
