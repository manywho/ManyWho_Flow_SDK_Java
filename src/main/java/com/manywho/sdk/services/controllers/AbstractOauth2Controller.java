package com.manywho.sdk.services.controllers;

import com.manywho.sdk.entities.UserObject;
import com.manywho.sdk.entities.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.entities.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.enums.AuthorizationType;
import com.manywho.sdk.services.annotations.AuthorizationRequired;
import com.manywho.sdk.services.oauth.AbstractOauth2Provider;
import org.scribe.builder.ServiceBuilder;
import org.scribe.oauth.OAuthService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

public abstract class AbstractOauth2Controller extends AbstractOauthController {
    protected AbstractOauth2Provider oauth2Provider;

    public AbstractOauth2Controller(AbstractOauth2Provider oauth2Provider) {
        this.oauth2Provider = oauth2Provider;
    }

    public AbstractOauth2Provider getOauth2Provider() {
        return oauth2Provider;
    }

    public OAuthService getOauthService() {
        return new ServiceBuilder()
                .provider(oauth2Provider)
                .callback(oauth2Provider.getRedirectUri())
                .apiKey(oauth2Provider.getClientId())
                .apiSecret(oauth2Provider.getClientSecret())
                .build();
    }

    @Path("/authorization")
    @POST
    @AuthorizationRequired
    public ObjectDataResponse authorization(ObjectDataRequest objectDataRequest) throws Exception {
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
                new UserObject(this.getOauth2Provider().getName(), AuthorizationType.Oauth2, getOauthService().getAuthorizationUrl(null), authorizationStatus)
        );
    }
}
