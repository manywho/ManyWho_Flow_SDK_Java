package com.manywho.sdk.services.controllers;

import com.manywho.sdk.entities.security.AuthenticatedWho;
import org.glassfish.jersey.server.ContainerRequest;

import javax.ws.rs.core.Context;

public abstract class AbstractController {
    private ContainerRequest request;

    public AuthenticatedWho getAuthenticatedWho() {
        return (AuthenticatedWho) this.getRequest().getProperty("AuthenticatedWho");
    }

    public ContainerRequest getRequest() {
        return request;
    }

    @Context
    public void setRequest(ContainerRequest request) {
        this.request = request;
    }
}
