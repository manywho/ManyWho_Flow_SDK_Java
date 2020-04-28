package com.manywho.sdk.api;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CriteriaType {
    Equal("EQUAL"),
    NotEqual("NOT_EQUAL"),
    GreaterThan("GREATER_THAN"),
    GreaterThanOrEqual("GREATER_THAN_OR_EQUAL"),
    LessThan("LESS_THAN"),
    LessThanOrEqual("LESS_THAN_OR_EQUAL"),
    Contains("CONTAINS"),
    StartsWith("STARTS_WITH"),
    EndsWith("ENDS_WITH"),
    IsEmpty("IS_EMPTY");

    private final String text;

    CriteriaType(final String text) {
        this.text = text;
    }

    @JsonCreator
    public static CriteriaType forValue(String value) {
        for (CriteriaType criteriaType : values()) {
            if (value.equalsIgnoreCase(criteriaType.text)) {
                return criteriaType;
            }
        }

        throw new IllegalArgumentException("No criteria type with text " + value + " found");
    }

    @Override
    public String toString() {
        return text;
    }
}
