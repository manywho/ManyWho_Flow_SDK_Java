package com.manywho.sdk.services.unit.entities;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.actions.Action;

public class TestActionWithoutMetadata {
    @Action.Input(name = "Name", contentType = ContentType.String)
    private String name;
}
