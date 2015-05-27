package com.manywho.sdk.enums;

public enum EndpointType {
    Load("LOAD"),
    Save("SAVE");

    private final String text;

    private EndpointType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public static EndpointType fromString(String text) {
        if (text != null) {
            for (EndpointType invokeType : EndpointType.values()) {
                if (text.equalsIgnoreCase(invokeType.text)) {
                    return invokeType;
                }
            }
        }

        throw new IllegalArgumentException("No constant with text " + text + " found");
    }
}
