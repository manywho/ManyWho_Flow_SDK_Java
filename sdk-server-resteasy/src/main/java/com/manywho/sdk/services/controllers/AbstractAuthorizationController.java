package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public abstract class AbstractAuthorizationController implements AuthorizationController {
    @Path("/authorization")
    @POST
    public abstract ObjectDataResponse authorization(ObjectDataRequest objectDataRequest) throws Exception;
}
