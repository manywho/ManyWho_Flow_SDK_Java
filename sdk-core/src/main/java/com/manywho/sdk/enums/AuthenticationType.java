package com.manywho.sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

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

    @JsonCreator
    public static AuthenticationType forValue(String value) {
        for (AuthenticationType authenticationType : values()) {
            if (value.equalsIgnoreCase(authenticationType.text)) {
                return authenticationType;
            }
        }

        throw new IllegalArgumentException("No constant with text " + value + " found");
    }
}
