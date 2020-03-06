package com.manywho.sdk.api.run;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * All the available modes to run a Flow as
 */
public enum FlowMode {
    /**
     * The default mode of running a Flow
     */
    Default(""),
    /**
     * Run the flow in Debug mode, which will populate state values in the response so you can see what is ready to be
     * committed and what values have already been committed to the state
     */
    Debug("DEBUG"),
    /**
     * Run the Flow in Debug Stepthrough mode, which will step through the Flow element by element. This allows you to
     * see exactly what's happening as your flow executes, as you are given the opportunity to see steps that are
     * normally not shown to the user (e.g. Database Loads and Message Actions)
     */
    DebugStepthrough("DEBUG_STEPTHROUGH"),
    /**
     * Run the Flow in Record mode, which allows you to progress through a Flow as normal, but each step is recorded,
     * with the ability to playback your "Recording" again in the future, e.g. for testing
     */
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
