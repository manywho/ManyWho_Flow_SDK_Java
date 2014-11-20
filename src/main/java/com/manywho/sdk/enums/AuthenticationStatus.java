package com.manywho.sdk.enums;

public enum AuthenticationStatus {
    AccessDenied("ACCESS_DENIED"),
    Authenticated("AUTHENTICATED");

    private final String text;

    private AuthenticationStatus(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
