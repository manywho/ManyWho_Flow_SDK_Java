package com.manywho.sdk.services.entities;

import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.api.security.AuthenticatedWhoResult;
import com.manywho.sdk.api.security.AuthenticationCredentials;
import com.manywho.sdk.services.controllers.AbstractIdentityController;

public class TestIdentityController extends AbstractIdentityController {

    @Override
    public AuthenticatedWhoResult authentication(AuthenticationCredentials authenticationCredentials) throws Exception {
        return null;
    }

    @Override
    public ObjectDataResponse authorization(ObjectDataRequest objectDataRequest) throws Exception {
        return null;
    }

    @Override
    public ObjectDataResponse groupAttributes(ObjectDataRequest objectDataRequest) throws Exception {
        return null;
    }

    @Override
    public ObjectDataResponse groups(ObjectDataRequest objectDataRequest) throws Exception {
        return null;
    }

    @Override
    public ObjectDataResponse userAttributes(ObjectDataRequest objectDataRequest) throws Exception {
        return null;
    }

    @Override
    public ObjectDataResponse users(ObjectDataRequest objectDataRequest) throws Exception {
        return null;
    }
}
