package com.manywho.sdk.entities.run.state;

import com.manywho.sdk.entities.draw.flow.FlowId;

import java.util.Date;

public class StateEntry {
    private String id;
    private FlowId flowId;
    private String flowDeveloperName;
    private String mapElementId;
    private String mapElementDeveloperName;
    private Date dateCommitted;
    private StateValueCollection values;
    private UserInteractionCollection userInteractions;

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

    public Date getDateCommitted() {
        return dateCommitted;
    }

    public void setDateCommitted(Date dateCommitted) {
        this.dateCommitted = dateCommitted;
    }

    public StateValueCollection getValues() {
        return values;
    }

    public void setValues(StateValueCollection values) {
        this.values = values;
    }

    public UserInteractionCollection getUserInteractions() {
        return userInteractions;
    }

    public void setUserInteractions(UserInteractionCollection userInteractions) {
        this.userInteractions = userInteractions;
    }
}
