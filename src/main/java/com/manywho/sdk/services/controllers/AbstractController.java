package com.manywho.sdk.services.controllers;

import com.manywho.sdk.entities.run.elements.config.ServiceRequest;
import com.manywho.sdk.entities.security.AuthenticatedWho;
import com.manywho.sdk.services.PropertyCollectionParser;
import org.glassfish.jersey.server.ContainerRequest;

import javax.inject.Inject;
import javax.ws.rs.core.Context;

public abstract class AbstractController {
    @Context
    private ContainerRequest request;

    @Inject
    protected PropertyCollectionParser propertyCollectionParser;

    public AuthenticatedWho getAuthenticatedWho() {
        return (AuthenticatedWho) this.request.getProperty("AuthenticatedWho");
    }

    protected <T> T parseInputs(ServiceRequest serviceRequest, Class<T> tClass) throws Exception {
        return propertyCollectionParser.parse(serviceRequest.getInputs(), tClass);
    }
}
