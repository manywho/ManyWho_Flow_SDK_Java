package com.manywho.sdk.services.functional.functional.actions;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.actions.Action;

import java.time.OffsetDateTime;

@Action.Metadata(name = "Test Action", summary = "This is a test action", uri = "testaction")
public class TestAction {
    @Action.Input(name = "Name", contentType = ContentType.String)
    private String name;

    @Action.Output(name = "Created At", contentType = ContentType.DateTime, required = false)
    private OffsetDateTime createdAt;
}
