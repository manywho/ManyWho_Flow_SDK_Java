package com.manywho.sdk.api.draw.log;

import com.manywho.sdk.api.draw.elements.Element;

import java.util.Map;

public class Log extends Element {
    private String stateId;
    private String flowId;
    private String flowDeveloperName;
    private Map<String, LogEntry> entries;

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getFlowDeveloperName() {
        return flowDeveloperName;
    }

    public void setFlowDeveloperName(String flowDeveloperName) {
        this.flowDeveloperName = flowDeveloperName;
    }

    public Map<String, LogEntry> getEntries() {
        return entries;
    }

    public void setEntries(Map<String, LogEntry> entries) {
        this.entries = entries;
    }
}
