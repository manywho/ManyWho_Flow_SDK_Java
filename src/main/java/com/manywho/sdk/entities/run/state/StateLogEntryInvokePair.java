package com.manywho.sdk.entities.run.state;

import com.manywho.sdk.entities.run.EngineInvokeRequest;
import com.manywho.sdk.entities.run.EngineInvokeResponse;

public class StateLogEntryInvokePair {
    private EngineInvokeRequest engineInvokeRequest;
    private EngineInvokeResponse engineInvokeResponse;
    private String order;

    public EngineInvokeRequest getEngineInvokeRequest() {
        return engineInvokeRequest;
    }

    public void setEngineInvokeRequest(EngineInvokeRequest engineInvokeRequest) {
        this.engineInvokeRequest = engineInvokeRequest;
    }

    public EngineInvokeResponse getEngineInvokeResponse() {
        return engineInvokeResponse;
    }

    public void setEngineInvokeResponse(EngineInvokeResponse engineInvokeResponse) {
        this.engineInvokeResponse = engineInvokeResponse;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
