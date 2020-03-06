package com.manywho.sdk.api.run.state;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.run.EngineInvokeRequest;
import com.manywho.sdk.api.run.EngineInvokeResponse;

import java.util.ArrayList;
import java.util.List;

public class StateLogEntry {
    private EngineInvokeRequest engineInvokeRequest;
    private EngineInvokeResponse engineInvokeResponse;
    private List<StateLogEntryInvokePair> stateLogEntryInvokePairs = Lists.newArrayList();
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

    public List<StateLogEntryInvokePair> getStateLogEntryInvokePairs() {
        return stateLogEntryInvokePairs;
    }

    public void setStateLogEntryInvokePairs(List<StateLogEntryInvokePair> stateLogEntryInvokePairs) {
        this.stateLogEntryInvokePairs = MoreObjects.firstNonNull(stateLogEntryInvokePairs, new ArrayList<StateLogEntryInvokePair>());
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
