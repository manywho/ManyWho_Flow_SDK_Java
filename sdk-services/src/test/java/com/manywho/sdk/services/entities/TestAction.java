package com.manywho.sdk.services.entities;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.actions.Action;

import java.time.OffsetDateTime;
import java.util.List;

@Action.Metadata(name = "Test Action", summary = "Test summary", uri = "testaction")
public class TestAction {
    @Action.Input(name = "Name", contentType = ContentType.String)
    private String name;

    @Action.Input(name = "Type", contentType = ContentType.Object)
    private TestType type;

    @Action.Input(name = "Types", contentType = ContentType.List)
    private List<TestType> types;

    @Action.Output(name = "Created At", contentType = ContentType.DateTime)
    private OffsetDateTime createdAt;

    public String getName() {
        return name;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
}
