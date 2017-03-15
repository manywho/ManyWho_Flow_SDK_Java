package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.api.security.AuthenticatedWhoResult;
import com.manywho.sdk.api.security.AuthenticationCredentials;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public abstract class AbstractIdentityController implements IdentityController {
    /**
     * This endpoint will attempt to authenticate a user, based on the incoming credentials in
     * the {@code authenticationCredentials} parameter.
     * <p>
     * A successful authentication will return an {@code AuthenticatedWhoResult} object, containing the details of the
     * user, with the {@code AuthenticatedWhoResult.status} field set to {@code AuthenticationStatus.Authenticated}.
     * <p>
     * An unsuccessful authentication will return an {@code AuthenticatedWhoResult} object, with
     * the {@code AuthenticatedWhoResult.status} field set to {@code AuthenticationStatus.AccessDenied} and a relevant
     * message in the {@code AuthenticatedWhoResult.statusMessage} field. {@code AuthenticatedWhoResult} contains
     * methods that will return a valid result when authentication is unsuccessful
     * ({@code AuthenticatedWhoResult.createDeniedResult()}).
     *
     * @param authenticationCredentials the provided credentials of the user to authenticate
     * @return an {@code AuthenticatedWhoResult} detailing whether the user was authenticated or not
     * @throws Exception
     */
    @Path("/authentication")
    @POST
    public abstract AuthenticatedWhoResult authentication(AuthenticationCredentials authenticationCredentials) throws Exception;

    @Path("/authorization")
    @POST
    public abstract ObjectDataResponse authorization(ObjectDataRequest objectDataRequest) throws Exception;

    @Path("/authorization/group/attribute")
    @POST
    public abstract ObjectDataResponse groupAttributes(ObjectDataRequest objectDataRequest) throws Exception;

    @Path("/authorization/group")
    @POST
    public abstract ObjectDataResponse groups(ObjectDataRequest objectDataRequest) throws Exception;

    @Path("/authorization/user/attribute")
    @POST
    public abstract ObjectDataResponse userAttributes(ObjectDataRequest objectDataRequest) throws Exception;

    @Path("/authorization/user")
    @POST
    public abstract ObjectDataResponse users(ObjectDataRequest objectDataRequest) throws Exception;
}
