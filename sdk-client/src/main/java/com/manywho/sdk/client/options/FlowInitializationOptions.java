package com.manywho.sdk.client.options;

import com.manywho.sdk.enums.FlowMode;

public class FlowInitializationOptions {
    private FlowMode mode;

    /**
     * Gets the desired mode to run the Flow as
     *
     * @return the desired mode to run the Flow as
     */
    public FlowMode getMode() {
        return mode;
    }

    /**
     * Set the mode to run the Flow as. See {@link FlowMode} for the available modes
     *
     * @param mode the mode to run the Flow as
     * @return this {@link FlowInitializationOptions} object for fluent building
     */
    public FlowInitializationOptions setMode(FlowMode mode) {
        this.mode = mode;
        return this;
    }
}
