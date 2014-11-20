package com.manywho.sdk.entities;

import com.manywho.sdk.enums.AuthenticationStatus;

public class AuthenticatedWhoResult extends AuthenticatedWho {
    private AuthenticationStatus status;
    private String statusMessage;

    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
