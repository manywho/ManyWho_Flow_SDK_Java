package com.manywho.sdk.api;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ContentType {
    Boolean("ContentBoolean"),
    Content("ContentContent"),
    DateTime("ContentDateTime"),
    Encrypted("ContentEncrypted"),
    List("ContentList"),
    Number("ContentNumber"),
    Object("ContentObject"),
    Password("ContentPassword"),
    String("ContentString");

    private final String text;

    ContentType(final String text) {
        this.text = text;
    }

    @JsonCreator
    public static ContentType forValue(String value) {
        for (ContentType contentType : values()) {
            if (value.equalsIgnoreCase(contentType.text)) {
                return contentType;
            }
        }

        throw new IllegalArgumentException("No content type with text " + value + " found");
    }

    @Override
    public String toString() {
        return text;
    }
}
