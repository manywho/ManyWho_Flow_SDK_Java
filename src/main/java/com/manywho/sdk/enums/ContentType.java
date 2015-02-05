package com.manywho.sdk.enums;

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

    @Override
    public String toString() {
        return text;
    }
}
