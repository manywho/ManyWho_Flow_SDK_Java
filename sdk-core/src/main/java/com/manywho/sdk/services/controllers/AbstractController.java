package com.manywho.sdk.services.controllers;

import com.manywho.sdk.entities.ConfigurationValuesAware;
import com.manywho.sdk.entities.run.elements.config.ServiceRequest;
import com.manywho.sdk.entities.security.AuthenticatedWho;
import com.manywho.sdk.services.PropertyCollectionParser;
import com.manywho.sdk.services.actions.ActionParser;
import com.manywho.sdk.services.annotations.Action;
import org.glassfish.jersey.server.ContainerRequest;

import javax.inject.Inject;
import javax.ws.rs.core.Context;

public abstract class AbstractController {
    @Context
    protected ContainerRequest request;

    @Inject
    protected ActionParser actionParser;

    @Inject
    protected PropertyCollectionParser propertyCollectionParser;

    public AuthenticatedWho getAuthenticatedWho() {
        return (AuthenticatedWho) this.request.getProperty("AuthenticatedWho");
    }

    protected <T> T parseConfigurationValues(ConfigurationValuesAware configurationValuesAware, Class<T> tClass) throws Exception {
        return propertyCollectionParser.parse(configurationValuesAware.getConfigurationValues(), tClass);
    }

    protected <T> T parseInputs(ServiceRequest serviceRequest, Class<T> tClass) throws Exception {
        if (tClass.isAnnotationPresent(Action.class)) {
            return actionParser.parseInputs(serviceRequest.getInputs(), tClass);
        }

        return propertyCollectionParser.parse(serviceRequest.getInputs(), tClass);
    }
}
