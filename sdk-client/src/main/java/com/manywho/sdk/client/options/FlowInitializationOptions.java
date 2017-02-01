package com.manywho.sdk.client.options;

import com.google.common.collect.Lists;
import com.manywho.sdk.client.entities.FlowInput;
import com.manywho.sdk.enums.FlowMode;

import java.util.List;

public class FlowInitializationOptions {
    private List<FlowInput> inputs = Lists.newArrayList();
    private FlowMode mode = FlowMode.Default;

    /**
     * Gets the inputs to pass into the Flow
     *
     * @return a list of the inputs to pass into the Flow
     */
    public List<FlowInput> getInputs() {
        return inputs;
    }

    /**
     * Add an input to pass into the Flow
     *
     * @param input the input to pass into the Flow
     * @return this {@link FlowInitializationOptions} object for fluent building
     */
    public FlowInitializationOptions addInput(FlowInput input) {
        this.inputs.add(input);
        return this;
    }

    /**
     * Set the inputs to pass into the Flow
     *
     * @param inputs a list of the inputs to pass into the Flow
     * @return this {@link FlowInitializationOptions} object for fluent building
     */
    public FlowInitializationOptions setInputs(List<FlowInput> inputs) {
        this.inputs = inputs;
        return this;
    }

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
