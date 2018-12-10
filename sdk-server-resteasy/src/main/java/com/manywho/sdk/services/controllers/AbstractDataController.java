package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public abstract class AbstractDataController implements DataController {
    @Override
    @Path("/delete")
    @POST
    public abstract ObjectDataResponse delete(ObjectDataRequest objectDataRequest) throws Exception;

    @Override
    @POST
    public abstract ObjectDataResponse load(@Valid @NotNull ObjectDataRequest objectDataRequest) throws Exception;

    @Override
    @PUT
    public abstract ObjectDataResponse save(ObjectDataRequest objectDataRequest) throws Exception;
}
