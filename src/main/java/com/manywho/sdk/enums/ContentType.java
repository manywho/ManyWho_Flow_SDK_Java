package com.manywho.sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ContentType {
    Boolean("ContentBoolean"),
    Content("ContentContent"),
    DateTime("ContentDateTime"),
    List("ContentList"),
    Number("ContentNumber"),
    Object("ContentObject"),
    Password("ContentPassword"),
    String("ContentString");

    private final String text;

    private ContentType(final String text) {
        this.text = text;
    }

    @JsonCreator
    public static ContentType forValue(String value) {
        for (ContentType contentType : values()) {
            if (value.equalsIgnoreCase(contentType.toString())) {
                return contentType;
            }
        }

        throw new IllegalArgumentException("No constant with text " + value + " found");
    }

    @Override
    public String toString() {
        return text;
    }
}
