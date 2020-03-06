package com.manywho.sdk.services.unit.entities;

import com.manywho.sdk.services.types.Type;

@Type.Element(name = "Type Without Properties")
public class TestTypeWithoutProperties implements Type {

    @Type.Identifier
    private String id;
}
