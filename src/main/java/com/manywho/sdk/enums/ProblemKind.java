package com.manywho.sdk.enums;

public enum ProblemKind {
    Api("api"),
    Service("service");

    private final String text;

    private ProblemKind(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
