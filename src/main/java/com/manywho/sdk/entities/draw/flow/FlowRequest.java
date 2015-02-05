package com.manywho.sdk.entities.draw.flow;

import com.manywho.sdk.entities.draw.elements.group.GroupAuthorization;
import com.manywho.sdk.entities.run.Request;

public class FlowRequest implements Request {
    protected String editingToken;
    protected FlowId id;
    protected String developerName;
    protected String developerSummary;
    protected String startMapElementId;
    protected boolean allowJumping;
    protected GroupAuthorization authorization;

    public String getEditingToken() {
        return editingToken;
    }

    public void setEditingToken(String editingToken) {
        this.editingToken = editingToken;
    }

    public FlowId getId() {
        return id;
    }

    public void setId(FlowId id) {
        this.id = id;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getDeveloperSummary() {
        return developerSummary;
    }

    public void setDeveloperSummary(String developerSummary) {
        this.developerSummary = developerSummary;
    }

    public String getStartMapElementId() {
        return startMapElementId;
    }

    public void setStartMapElementId(String startMapElementId) {
        this.startMapElementId = startMapElementId;
    }

    public boolean isAllowJumping() {
        return allowJumping;
    }

    public void setAllowJumping(boolean allowJumping) {
        this.allowJumping = allowJumping;
    }

    public GroupAuthorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(GroupAuthorization authorization) {
        this.authorization = authorization;
    }
}
