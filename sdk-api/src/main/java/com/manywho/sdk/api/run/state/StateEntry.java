package com.manywho.sdk.api.run.state;

import com.manywho.sdk.api.draw.flow.FlowId;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class StateEntry {
    private UUID id;
    private FlowId flowId;
    private String flowDeveloperName;
    private UUID mapElementId;
    private String mapElementDeveloperName;
    private LocalDateTime dateCommitted;
    private List<StateValue> values;
    private List<UserInteraction> userInteractions;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public FlowId getFlowId() {
        return flowId;
    }

    public void setFlowId(FlowId flowId) {
        this.flowId = flowId;
    }

    public String getFlowDeveloperName() {
        return flowDeveloperName;
    }

    public void setFlowDeveloperName(String flowDeveloperName) {
        this.flowDeveloperName = flowDeveloperName;
    }

    public UUID getMapElementId() {
        return mapElementId;
    }

    public void setMapElementId(UUID mapElementId) {
        this.mapElementId = mapElementId;
    }

    public String getMapElementDeveloperName() {
        return mapElementDeveloperName;
    }

    public void setMapElementDeveloperName(String mapElementDeveloperName) {
        this.mapElementDeveloperName = mapElementDeveloperName;
    }

    public LocalDateTime getDateCommitted() {
        return dateCommitted;
    }

    public void setDateCommitted(LocalDateTime dateCommitted) {
        this.dateCommitted = dateCommitted;
    }

    public List<StateValue> getValues() {
        return values;
    }

    public void setValues(List<StateValue> values) {
        this.values = values;
    }

    public List<UserInteraction> getUserInteractions() {
        return userInteractions;
    }

    public void setUserInteractions(List<UserInteraction> userInteractions) {
        this.userInteractions = userInteractions;
    }
}
