package com.manywho.sdk.services.controllers;

import com.manywho.sdk.entities.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.entities.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.entities.security.AuthenticatedWhoResult;
import com.manywho.sdk.entities.security.AuthenticationCredentials;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

public abstract class AbstractOauthController extends AbstractController {
    @Path("/authorization/user/attribute")
    @POST
    public ObjectDataResponse userAttributes(ObjectDataRequest objectDataRequest) {
        return new ObjectDataResponse();
    }

    @Path("/authorization/group/attribute")
    @POST
    public ObjectDataResponse groupAttributes(ObjectDataRequest objectDataRequest) {
        return new ObjectDataResponse();
    }

    @Path("/authentication")
    @POST
    public abstract AuthenticatedWhoResult authentication(AuthenticationCredentials authenticationCredentials) throws Exception;
}
