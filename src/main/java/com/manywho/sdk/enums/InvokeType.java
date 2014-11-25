package com.manywho.sdk.enums;

public enum InvokeType {
    Done("DONE"),
    Forward("FORWARD"),
    Join("JOIN"),
    Navigate("NAVIGATE"),
    Status("STATUS"),
    Success("SUCCESS"),
    Sync("SYNC"),
    TokenCompleted("TOKEN_COMPLETED"),
    Wait("WAIT");

    private final String text;

    private InvokeType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
