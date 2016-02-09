package com.manywho.sdk.services.factories;

import com.manywho.sdk.entities.security.AuthenticatedWho;
import org.glassfish.hk2.api.Factory;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;

public class AuthenticatedWhoFactory implements Factory<AuthenticatedWho> {
    private final ContainerRequestContext containerRequestContext;

    @Inject
    public AuthenticatedWhoFactory(ContainerRequestContext containerRequestContext) {
        this.containerRequestContext = containerRequestContext;
    }

    @Override
    public AuthenticatedWho provide() {
        return (AuthenticatedWho) containerRequestContext.getProperty("AuthenticatedWho");
    }

    @Override
    public void dispose(AuthenticatedWho instance) {

    }
}
