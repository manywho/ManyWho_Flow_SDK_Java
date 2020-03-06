package com.manywho.sdk.api.draw.flow;

import com.manywho.sdk.api.draw.elements.group.GroupAuthorization;

import java.util.UUID;

public class FlowRequest {
    protected String editingToken;
    protected FlowId id;
    protected String developerName;
    protected String developerSummary;
    protected UUID startMapElementId;
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

    public UUID getStartMapElementId() {
        return startMapElementId;
    }

    public void setStartMapElementId(UUID startMapElementId) {
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
