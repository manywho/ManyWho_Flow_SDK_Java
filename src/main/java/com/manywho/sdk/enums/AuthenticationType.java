package com.manywho.sdk.enums;

public enum AuthenticationType {
    Public("PUBLIC"),
    AllUsers("ALL_USERS"),
    Specified("SPECIFIED");

    private final String text;

    private AuthenticationType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
