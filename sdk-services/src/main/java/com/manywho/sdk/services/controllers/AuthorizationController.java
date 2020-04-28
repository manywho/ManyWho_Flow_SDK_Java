package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;

public interface AuthorizationController {
    ObjectDataResponse authorization(ObjectDataRequest objectDataRequest) throws Exception;
}
