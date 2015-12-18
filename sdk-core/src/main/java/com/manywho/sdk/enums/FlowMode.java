package com.manywho.sdk.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum FlowMode {
    Default(""),
    Debug("DEBUG"),
    DebugStepthrough("DEBUG_STEPTHROUGH"),
    Record("RECORD");

    private final String text;

    FlowMode(final String text) {
        this.text = text;
    }

    @JsonCreator
    public static FlowMode forValue(String value) {
        for (FlowMode flowMode : values()) {
            if (value.equalsIgnoreCase(flowMode.text)) {
                return flowMode;
            }
        }

        throw new IllegalArgumentException("The mode " + value + " is not supported when running flows");
    }

    @Override
    public String toString() {
        return text;
    }
}
