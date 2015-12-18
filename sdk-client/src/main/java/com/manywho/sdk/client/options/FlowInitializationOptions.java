package com.manywho.sdk.client.options;

import com.manywho.sdk.enums.FlowMode;

public class FlowInitializationOptions {
    private FlowMode mode;

    public FlowMode getMode() {
        return mode;
    }

    public FlowInitializationOptions setMode(FlowMode mode) {
        this.mode = mode;
        return this;
    }
}
