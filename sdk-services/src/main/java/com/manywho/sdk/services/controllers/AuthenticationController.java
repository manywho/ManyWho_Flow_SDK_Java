package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.security.AuthenticatedWhoResult;
import com.manywho.sdk.api.security.AuthenticationCredentials;

public interface AuthenticationController {
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
    AuthenticatedWhoResult authentication(AuthenticationCredentials authenticationCredentials) throws Exception;
}
