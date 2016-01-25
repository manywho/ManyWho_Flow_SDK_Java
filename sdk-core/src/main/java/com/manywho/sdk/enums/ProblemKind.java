package com.manywho.sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ProblemKind {
    Api("api"),
    Service("service");

    private final String text;

    private ProblemKind(final String text) {
        this.text = text;
    }

    @JsonCreator
    public static ProblemKind forValue(String value) {
        for (ProblemKind problemKind : values()) {
            if (value.equalsIgnoreCase(problemKind.text)) {
                return problemKind;
            }
        }

        throw new IllegalArgumentException("No problem kind with text " + value + " found");
    }

    @Override
    public String toString() {
        return text;
    }
}
