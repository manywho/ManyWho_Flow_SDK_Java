package com.manywho.sdk.services.providers;

import com.google.inject.Provider;
import com.manywho.sdk.api.security.AuthenticatedWho;
import com.manywho.sdk.services.identity.AuthorizationEncoder;
import org.jboss.resteasy.plugins.guice.RequestScoped;

import javax.inject.Inject;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

@RequestScoped
public class AuthenticatedWhoProvider implements Provider<AuthenticatedWho> {
    private final HttpHeaders headers;
    private final AuthorizationEncoder authorizationEncoder;

    @Inject
    public AuthenticatedWhoProvider(@Context HttpHeaders headers, AuthorizationEncoder authorizationEncoder) {
        this.headers = headers;
        this.authorizationEncoder = authorizationEncoder;
    }

    @Override
    public AuthenticatedWho get() {
        String authorizationHeader = headers.getRequestHeaders().getFirst("Authorization");
        if (authorizationHeader == null) {
            throw new NotAuthorizedException("You are not authorized to access this endpoint");
        }

        return authorizationEncoder.decode(authorizationHeader);
    }
}
