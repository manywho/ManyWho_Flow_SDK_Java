package com.manywho.sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ComparisonType {
    None(""),
    And("AND"),
    Or("OR");

    private final String text;

    ComparisonType(final String text) {
        this.text = text;
    }

    @JsonCreator
    public static ComparisonType forValue(String value) {
        for (ComparisonType type : values()) {
            if (value.equalsIgnoreCase(type.text)) {
                return type;
            }
        }

        throw new IllegalArgumentException("No comparison type with text " + value + " found");
    }

    @Override
    public String toString() {
        return text;
    }
}
