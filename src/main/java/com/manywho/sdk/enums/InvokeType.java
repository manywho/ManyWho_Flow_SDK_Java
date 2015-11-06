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
    Wait("WAIT"),
    Busy("BUSY");

    private final String text;

    private InvokeType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public static InvokeType fromString(String text) {
        if (text != null) {
            for (InvokeType invokeType : InvokeType.values()) {
                if (text.equalsIgnoreCase(invokeType.text)) {
                    return invokeType;
                }
            }
        }

        throw new IllegalArgumentException("No constant with text " + text + " found");
    }
}
