package com.manywho.services.example.actions;

import com.manywho.sdk.services.actions.ActionCommand;
import com.manywho.sdk.services.actions.ActionResponse;

import java.time.OffsetDateTime;

public class AddAnnotationCommand implements ActionCommand<AddAnnotation, AddAnnotation.Input, AddAnnotation.Output> {
    @Override
    public ActionResponse<AddAnnotation.Output> execute(AddAnnotation.Input input) {
        return new ActionResponse<>(new AddAnnotation.Output(OffsetDateTime.now()));
    }
}
