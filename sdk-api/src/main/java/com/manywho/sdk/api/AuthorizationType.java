package com.manywho.sdk.api;

public enum AuthorizationType {
    UsernamePassword("USERNAME_PASSWORD"),
    Oauth("OAUTH"),
    Oauth2("OAUTH2"),
    SAML("SAML");

    private final String text;

    private AuthorizationType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
