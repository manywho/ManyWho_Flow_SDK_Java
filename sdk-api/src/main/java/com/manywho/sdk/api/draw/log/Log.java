package com.manywho.sdk.api.draw.log;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Maps;
import com.manywho.sdk.api.draw.elements.Element;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Log extends Element {
    private UUID stateId;
    private UUID flowId;
    private String flowDeveloperName;
    private Map<String, LogEntry> entries = Maps.newHashMap();

    public UUID getStateId() {
        return stateId;
    }

    public void setStateId(UUID stateId) {
        this.stateId = stateId;
    }

    public UUID getFlowId() {
        return flowId;
    }

    public void setFlowId(UUID flowId) {
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
        this.entries = MoreObjects.firstNonNull(entries, new HashMap<String, LogEntry>());
    }
}
