package com.manywho.sdk.services.controllers;

import com.manywho.sdk.entities.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.entities.run.elements.type.ObjectDataResponse;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

public abstract class AbstractDataController extends AbstractController {
    @Path("/data/delete")
    @POST
    public abstract ObjectDataResponse delete(ObjectDataRequest objectDataRequest) throws Exception;

    @Path("/data")
    @POST
    public abstract ObjectDataResponse load(ObjectDataRequest objectDataRequest) throws Exception;

    @Path("/data")
    @PUT
    public abstract ObjectDataResponse save(ObjectDataRequest objectDataRequest) throws Exception;
}
