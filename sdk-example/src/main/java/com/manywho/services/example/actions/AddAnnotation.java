package com.manywho.services.example.actions;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.actions.Action;
import com.manywho.sdk.services.actions.ActionResponse;
import com.manywho.sdk.services.values.Value;
import com.manywho.services.example.types.Person;

import java.time.OffsetDateTime;

@Action.Metadata(name = "Add Annotation", summary = "Add an annotation to a person", uri = "addannotation")
public class AddAnnotation implements Action<AddAnnotation, AddAnnotation> {
    @Action.Input
    @Value.Property(name = "Person", contentType = ContentType.Object)
    private Person person;

    @Action.Input
    @Value.Property(name = "Annotation", contentType = ContentType.String)
    private String annotation;

    @Action.Output
    @Value.Property(name = "Created At", contentType = ContentType.DateTime)
    private OffsetDateTime createdAt;

    @Override
    public ActionResponse<AddAnnotation> execute(AddAnnotation input) {
        return new ActionResponse<>(this);
    }
}
