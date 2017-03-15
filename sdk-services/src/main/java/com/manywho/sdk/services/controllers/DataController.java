package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface DataController {
    ObjectDataResponse delete(ObjectDataRequest objectDataRequest) throws Exception;

    ObjectDataResponse load(@Valid @NotNull ObjectDataRequest objectDataRequest) throws Exception;

    ObjectDataResponse save(ObjectDataRequest objectDataRequest) throws Exception;
}
