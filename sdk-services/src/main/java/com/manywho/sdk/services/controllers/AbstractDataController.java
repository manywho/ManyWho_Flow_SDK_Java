package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public abstract class AbstractDataController {
    @Path("/delete")
    @POST
    public abstract ObjectDataResponse delete(ObjectDataRequest objectDataRequest) throws Exception;

    @POST
    public abstract ObjectDataResponse load(@Valid @NotNull ObjectDataRequest objectDataRequest) throws Exception;

    @PUT
    public abstract ObjectDataResponse save(ObjectDataRequest objectDataRequest) throws Exception;
}
