package com.manywho.sdk.entities.run.state;

import com.manywho.sdk.entities.run.EngineInvokeRequest;
import com.manywho.sdk.entities.run.EngineInvokeResponse;

public class StateLogEntry {
    private EngineInvokeRequest engineInvokeRequest;
    private EngineInvokeResponse engineInvokeResponse;
    private StateLogEntryInvokePairCollection stateLogEntryInvokePairs;
    private String timeStamp;
    private String isActive;

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

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

    public StateLogEntryInvokePairCollection getStateLogEntryInvokePairs() {
        return stateLogEntryInvokePairs;
    }

    public void setStateLogEntryInvokePairs(StateLogEntryInvokePairCollection stateLogEntryInvokePairs) {
        this.stateLogEntryInvokePairs = stateLogEntryInvokePairs;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
