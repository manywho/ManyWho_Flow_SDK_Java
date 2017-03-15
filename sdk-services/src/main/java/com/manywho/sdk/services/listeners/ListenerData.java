package com.manywho.sdk.services.listeners;

import com.manywho.sdk.api.run.elements.config.ListenerServiceRequest;
import com.manywho.sdk.api.security.AuthenticatedWho;

public class ListenerData {
    private AuthenticatedWho authenticatedWho;
    private ListenerServiceRequest request;

    public ListenerData(AuthenticatedWho authenticatedWho, ListenerServiceRequest request) {
        this.authenticatedWho = authenticatedWho;
        this.request = request;
    }

    public AuthenticatedWho getAuthenticatedWho() {
        return authenticatedWho;
    }

    public ListenerServiceRequest getRequest() {
        return request;
    }
}
