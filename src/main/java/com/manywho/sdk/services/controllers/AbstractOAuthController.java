package com.manywho.sdk.services.controllers;

import com.manywho.sdk.entities.*;
import com.manywho.sdk.entities.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.entities.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.entities.security.AuthenticatedWhoResult;
import com.manywho.sdk.entities.security.AuthenticationCredentials;
import com.manywho.sdk.enums.AuthorizationType;
import com.manywho.sdk.services.oauth2.Oauth2Provider;
import com.manywho.sdk.services.annotations.AuthorizationRequired;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

public abstract class AbstractOAuthController extends AbstractController {
    protected Oauth2Provider oauth2Provider;

    public AbstractOAuthController(Oauth2Provider oauth2Provider) {
        this.oauth2Provider = oauth2Provider;
    }

    public Oauth2Provider getOauth2Provider() {
        return oauth2Provider;
    }

    @Path("/authorization")
    @POST
    @AuthorizationRequired
    public ObjectDataResponse authorization(ObjectDataRequest objectDataRequest) throws Exception {
        // @todo Check for configuration values, e.g. when install values aren't set
        String clientId = objectDataRequest.getConfigurationValues().getContentValue(this.getOauth2Provider().getClientIdValueName());

        String authorizationStatus = "401";

        switch (objectDataRequest.getAuthorization().getGlobalAuthenticationType()) {
            case Public:
                authorizationStatus = "200";
                break;
            case AllUsers:
                // @todo Not really sure how to get the user from Box for an ID
                if (!this.getAuthenticatedWho().getUserId().equalsIgnoreCase("PUBLIC_USER")) {
                    authorizationStatus = "200";
                }
                break;
            case Specified:
                break;
            default:
                break;
        }

        return new ObjectDataResponse(
                new UserObject(this.getOauth2Provider().getName(), AuthorizationType.Oauth2, this.getOauth2Provider().getAuthorizationUrl(clientId), authorizationStatus)
        );
    }

    @Path("/authentication")
    @POST
    public abstract AuthenticatedWhoResult authorization(AuthenticationCredentials authenticationCredentials);
}
