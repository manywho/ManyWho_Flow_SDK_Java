package com.manywho.sdk.services.actions;

import com.manywho.sdk.api.InvokeType;

public class ActionResponse<O> {
    private O outputs;
    private InvokeType invokeType = InvokeType.Forward;
    private String waitMessage;

    public ActionResponse(InvokeType invokeType) {
        this.invokeType = invokeType;
    }

    public ActionResponse(InvokeType invokeType, String waitMessage) {
        this.invokeType = invokeType;
        this.waitMessage = waitMessage;
    }

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

    public InvokeType getInvokeType() {
        return invokeType;
    }

    public O getOutputs() {
        return outputs;
    }

    public String getWaitMessage() {
        return waitMessage;
    }
}
