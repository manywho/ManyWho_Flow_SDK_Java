package com.manywho.sdk.services.actions;

import com.manywho.sdk.api.InvokeType;

public class ActionResponse<O> {
    private O outputs;
    private InvokeType invokeType = InvokeType.Forward;
    private String waitMessage;

    public ActionResponse(O outputs) {
        this.outputs = outputs;
    }

    public ActionResponse(O outputs, InvokeType invokeType) {
        this.outputs = outputs;
        this.invokeType = invokeType;
    }

    public ActionResponse(O outputs, InvokeType invokeType, String waitMessage) {
        this.outputs = outputs;
        this.invokeType = invokeType;
        this.waitMessage = waitMessage;
    }

    public O getOutputs() {
        return outputs;
    }

    public InvokeType getInvokeType() {
        return invokeType;
    }

    public String getWaitMessage() {
        return waitMessage;
    }
}
