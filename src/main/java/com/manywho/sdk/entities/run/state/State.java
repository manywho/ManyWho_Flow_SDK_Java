package com.manywho.sdk.entities.run.state;

import com.manywho.sdk.entities.draw.flow.FlowId;

import java.util.Date;
import java.util.Map;

public class State {
    private String id;
    private String parentId;
    private Date dateCreated;
    private Date dateModified;
    private FlowId currentFlowId;
    private String currentFlowDeveloperName;
    private String currentMapElementId;
    private String currentMapElementDeveloperName;
    private String currentStreamId;
    private String currentRunningUserId;
    private String externalIdentifier;
    private String manyWhoTenantId;
    private Map<String, String> annotations;
    private StateEntryCollection stateEntries;
    private StateEntry precommitStateEntry;
    private StateValueCollection values;
    private String authorizationHeader;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public FlowId getCurrentFlowId() {
        return currentFlowId;
    }

    public void setCurrentFlowId(FlowId currentFlowId) {
        this.currentFlowId = currentFlowId;
    }

    public String getCurrentFlowDeveloperName() {
        return currentFlowDeveloperName;
    }

    public void setCurrentFlowDeveloperName(String currentFlowDeveloperName) {
        this.currentFlowDeveloperName = currentFlowDeveloperName;
    }

    public String getCurrentMapElementId() {
        return currentMapElementId;
    }

    public void setCurrentMapElementId(String currentMapElementId) {
        this.currentMapElementId = currentMapElementId;
    }

    public String getCurrentMapElementDeveloperName() {
        return currentMapElementDeveloperName;
    }

    public void setCurrentMapElementDeveloperName(String currentMapElementDeveloperName) {
        this.currentMapElementDeveloperName = currentMapElementDeveloperName;
    }

    public String getCurrentStreamId() {
        return currentStreamId;
    }

    public void setCurrentStreamId(String currentStreamId) {
        this.currentStreamId = currentStreamId;
    }

    public String getCurrentRunningUserId() {
        return currentRunningUserId;
    }

    public void setCurrentRunningUserId(String currentRunningUserId) {
        this.currentRunningUserId = currentRunningUserId;
    }

    public String getExternalIdentifier() {
        return externalIdentifier;
    }

    public void setExternalIdentifier(String externalIdentifier) {
        this.externalIdentifier = externalIdentifier;
    }

    public String getManyWhoTenantId() {
        return manyWhoTenantId;
    }

    public void setManyWhoTenantId(String manyWhoTenantId) {
        this.manyWhoTenantId = manyWhoTenantId;
    }

    public Map<String, String> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    public StateEntryCollection getStateEntries() {
        return stateEntries;
    }

    public void setStateEntries(StateEntryCollection stateEntries) {
        this.stateEntries = stateEntries;
    }

    public StateEntry getPrecommitStateEntry() {
        return precommitStateEntry;
    }

    public void setPrecommitStateEntry(StateEntry precommitStateEntry) {
        this.precommitStateEntry = precommitStateEntry;
    }

    public StateValueCollection getValues() {
        return values;
    }

    public void setValues(StateValueCollection values) {
        this.values = values;
    }

    public String getAuthorizationHeader() {
        return authorizationHeader;
    }

    public void setAuthorizationHeader(String authorizationHeader) {
        this.authorizationHeader = authorizationHeader;
    }
}
