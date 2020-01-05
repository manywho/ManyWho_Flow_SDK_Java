package com.manywho.sdk.api.run.state;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.manywho.sdk.api.draw.flow.FlowId;
import com.manywho.sdk.api.draw.log.Log;

import java.time.LocalDateTime;
import java.util.*;

public class State {
    private UUID id;
    private UUID parentId;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;
    private FlowId currentFlowId;
    private String currentFlowDeveloperName;
    private UUID currentMapElementId;
    private String currentMapElementDeveloperName;
    private String currentStreamId;
    private UUID currentRunningUserId;
    private String currentRunningUserEmail;
    private String externalIdentifier;
    @JsonProperty("manywhoTenantId")
    private UUID manyWhoTenantId;
    private Map<String, String> annotations = Maps.newHashMap();
    private List<StateEntry> stateEntries = Lists.newArrayList();
    private StateEntry precommitStateEntry;
    private List<StateValue> values = Lists.newArrayList();
    private String authorizationHeader;
    @JsonProperty("isDone")
    private boolean done;
    private Log log;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
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

    public UUID getCurrentMapElementId() {
        return currentMapElementId;
    }

    public void setCurrentMapElementId(UUID currentMapElementId) {
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

    public UUID getCurrentRunningUserId() {
        return currentRunningUserId;
    }

    public void setCurrentRunningUserId(UUID currentRunningUserId) {
        this.currentRunningUserId = currentRunningUserId;
    }

    public String getCurrentRunningUserEmail() {
        return currentRunningUserEmail;
    }

    public void setCurrentRunningUserEmail(String currentRunningUserEmail) {
        this.currentRunningUserEmail = currentRunningUserEmail;
    }

    public String getExternalIdentifier() {
        return externalIdentifier;
    }

    public void setExternalIdentifier(String externalIdentifier) {
        this.externalIdentifier = externalIdentifier;
    }

    public UUID getManyWhoTenantId() {
        return manyWhoTenantId;
    }

    public void setManyWhoTenantId(UUID manyWhoTenantId) {
        this.manyWhoTenantId = manyWhoTenantId;
    }

    public Map<String, String> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = MoreObjects.firstNonNull(annotations, new HashMap<String, String>());
    }

    public List<StateEntry> getStateEntries() {
        return stateEntries;
    }

    public boolean hasStateEntries() {
        return !stateEntries.isEmpty();
    }

    public void setStateEntries(List<StateEntry> stateEntries) {
        this.stateEntries = MoreObjects.firstNonNull(stateEntries, new ArrayList<StateEntry>());
    }

    public StateEntry getPrecommitStateEntry() {
        return precommitStateEntry;
    }

    public void setPrecommitStateEntry(StateEntry precommitStateEntry) {
        this.precommitStateEntry = precommitStateEntry;
    }

    public List<StateValue> getValues() {
        return values;
    }

    public boolean hasValues() {
        return !values.isEmpty();
    }

    public void setValues(List<StateValue> values) {
        this.values = MoreObjects.firstNonNull(values, new ArrayList<StateValue>());
    }

    public String getAuthorizationHeader() {
        return authorizationHeader;
    }

    public void setAuthorizationHeader(String authorizationHeader) {
        this.authorizationHeader = authorizationHeader;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }
}
