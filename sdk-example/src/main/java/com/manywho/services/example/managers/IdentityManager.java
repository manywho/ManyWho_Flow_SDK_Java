package com.manywho.services.example.managers;

import com.google.inject.Provider;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.api.security.AuthenticatedWho;
import com.manywho.sdk.api.security.AuthenticatedWhoResult;
import com.manywho.sdk.api.security.AuthenticationCredentials;
import com.manywho.services.example.services.identity.AuthenticationService;
import com.manywho.services.example.services.identity.AuthorizationService;

import javax.inject.Inject;
import java.util.List;

public class IdentityManager {
    private final Provider<AuthenticatedWho> authenticatedWhoProvider;
    private final AuthorizationService authorizationService;
    private final AuthenticationService authenticationService;

    @Inject
    public IdentityManager(Provider<AuthenticatedWho> authenticatedWhoProvider, AuthorizationService authorizationService, AuthenticationService authenticationService) {
        this.authenticatedWhoProvider = authenticatedWhoProvider;
        this.authorizationService = authorizationService;
        this.authenticationService = authenticationService;
    }

    public ObjectDataResponse authorization(ObjectDataRequest objectDataRequest) {
        AuthenticatedWho user = authenticatedWhoProvider.get();

        List<MObject> userObject;

        switch (objectDataRequest.getAuthorization().getGlobalAuthenticationType()) {
            case AllUsers:
                userObject = authorizationService.withAllUsers(user);
                break;
            case Public:
                userObject = authorizationService.withPublic(user);
                break;
            case Specified:
                userObject = authorizationService.withSpecified(user, objectDataRequest);
                break;
            default:
                userObject = authorizationService.createUserObject(user, "401");
                break;
        }

        return new ObjectDataResponse(userObject);
    }

    public AuthenticatedWhoResult authentication(AuthenticationCredentials authenticationCredentials) {
        if (authenticationService.isValidUser(authenticationCredentials.getUsername(), authenticationCredentials.getPassword())) {
            return authenticationService.authenticateUser(authenticationCredentials.getUsername());
        }

        return AuthenticatedWhoResult.createDeniedResult();
    }

    public ObjectDataResponse groupAttributes(ObjectDataRequest objectDataRequest) {
        return new ObjectDataResponse(authorizationService.loadGroupAttributes());
    }

    public ObjectDataResponse groups(ObjectDataRequest objectDataRequest) {
        return new ObjectDataResponse(authorizationService.loadGroups());
    }

    public ObjectDataResponse users(ObjectDataRequest objectDataRequest) {
        return new ObjectDataResponse();
    }

    public ObjectDataResponse usersAttributes(ObjectDataRequest objectDataRequest) {
        return new ObjectDataResponse();
    }
}
