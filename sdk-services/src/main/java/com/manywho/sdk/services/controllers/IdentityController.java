package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;

public interface IdentityController extends AuthenticationController, AuthorizationController {
    ObjectDataResponse groupAttributes(ObjectDataRequest objectDataRequest) throws Exception;

    ObjectDataResponse groups(ObjectDataRequest objectDataRequest) throws Exception;

    ObjectDataResponse userAttributes(ObjectDataRequest objectDataRequest) throws Exception;

    ObjectDataResponse users(ObjectDataRequest objectDataRequest) throws Exception;
}
