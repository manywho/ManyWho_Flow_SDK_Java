package com.manywho.sdk.services.unit.entities;

import com.manywho.sdk.services.types.Type;

@Type.Element(name = TestTypeWithoutIdentifier.NAME)
public class TestTypeWithoutIdentifier implements Type {
    static final String NAME = "Type Without Identifier";
}
