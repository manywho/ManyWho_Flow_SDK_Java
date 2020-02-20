package com.manywho.sdk.api.run.state;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.draw.flow.FlowId;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StateEntry {
    private UUID id;
    private FlowId flowId;
    private String flowDeveloperName;
    private UUID mapElementId;
    private String mapElementDeveloperName;
    private OffsetDateTime dateCommitted;
    private List<StateValue> values = Lists.newArrayList();
    private List<UserInteraction> userInteractions = Lists.newArrayList();

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

    public OffsetDateTime getDateCommitted() {
        return dateCommitted;
    }

    public void setDateCommitted(OffsetDateTime dateCommitted) {
        this.dateCommitted = dateCommitted;
    }

    public List<StateValue> getValues() {
        return values;
    }

    public void setValues(List<StateValue> values) {
        this.values = MoreObjects.firstNonNull(values, new ArrayList<StateValue>());
    }

    public List<UserInteraction> getUserInteractions() {
        return userInteractions;
    }

    public void setUserInteractions(List<UserInteraction> userInteractions) {
        this.userInteractions = MoreObjects.firstNonNull(userInteractions, new ArrayList<UserInteraction>());
    }
}
