package com.manywho.sdk.api.run.state;

import com.manywho.sdk.api.draw.flow.FlowId;

import java.time.LocalDateTime;
import java.util.List;

public class StateEntry {
    private String id;
    private FlowId flowId;
    private String flowDeveloperName;
    private String mapElementId;
    private String mapElementDeveloperName;
    private LocalDateTime dateCommitted;
    private List<StateValue> values;
    private List<UserInteraction> userInteractions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getMapElementId() {
        return mapElementId;
    }

    public void setMapElementId(String mapElementId) {
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
