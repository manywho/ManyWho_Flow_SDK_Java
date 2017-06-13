package com.manywho.sdk.api.run;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.elements.map.MapElementInvokeResponse;
import com.manywho.sdk.api.run.elements.map.VoteResponse;
import com.manywho.sdk.api.run.elements.ui.NavigationElementReference;
import com.manywho.sdk.api.run.state.StateLog;
import com.manywho.sdk.api.translate.Culture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class EngineInvokeResponse {
    private Culture culture;
    private UUID stateId;
    private UUID parentStateId;
    private UUID stateToken;
    private String alertEmail;
    private String waitMessage;
    private String notAuthorizedMessage;
    private UUID currentMapElementId;
    private String currentStreamId;
    private InvokeType invokeType;
    private Map<String, String> annotations = Maps.newHashMap();
    private List<MapElementInvokeResponse> mapElementInvokeResponses = Lists.newArrayList();
    private VoteResponse voteResponse;
    private StateLog stateLog;
    private List<EngineValue> preCommitStateValues = Lists.newArrayList();
    private List<EngineValue> stateValues = Lists.newArrayList();
    private List<EngineValue> outputs = Lists.newArrayList();
    private String statusCode;
    private String runFlowUri;
    private String joinFlowUri;
    private EngineAuthorizationContext authorizationContext;
    private List<NavigationElementReference> navigationElementReferences = Lists.newArrayList();

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public UUID getStateId() {
        return stateId;
    }

    public void setStateId(UUID stateId) {
        this.stateId = stateId;
    }

    public UUID getParentStateId() {
        return parentStateId;
    }

    public void setParentStateId(UUID parentStateId) {
        this.parentStateId = parentStateId;
    }

    public UUID getStateToken() {
        return stateToken;
    }

    public void setStateToken(UUID stateToken) {
        this.stateToken = stateToken;
    }

    public String getAlertEmail() {
        return alertEmail;
    }

    public void setAlertEmail(String alertEmail) {
        this.alertEmail = alertEmail;
    }

    public String getWaitMessage() {
        return waitMessage;
    }

    public void setWaitMessage(String waitMessage) {
        this.waitMessage = waitMessage;
    }

    public String getNotAuthorizedMessage() {
        return notAuthorizedMessage;
    }

    public void setNotAuthorizedMessage(String notAuthorizedMessage) {
        this.notAuthorizedMessage = notAuthorizedMessage;
    }

    public UUID getCurrentMapElementId() {
        return currentMapElementId;
    }

    public void setCurrentMapElementId(UUID currentMapElementId) {
        this.currentMapElementId = currentMapElementId;
    }

    public String getCurrentStreamId() {
        return currentStreamId;
    }

    public void setCurrentStreamId(String currentStreamId) {
        this.currentStreamId = currentStreamId;
    }

    public InvokeType getInvokeType() {
        return invokeType;
    }

    public void setInvokeType(InvokeType invokeType) {
        this.invokeType = invokeType;
    }

    public Map<String, String> getAnnotations() {
        return annotations;
    }

    public boolean hasAnnotations() {
        return !annotations.isEmpty();
    }

    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = MoreObjects.firstNonNull(annotations, new HashMap<String, String>());
    }

    public List<MapElementInvokeResponse> getMapElementInvokeResponses() {
        return mapElementInvokeResponses;
    }

    public boolean hasMapElementInvokeResponses() {
        return !mapElementInvokeResponses.isEmpty();
    }

    public void setMapElementInvokeResponses(List<MapElementInvokeResponse> mapElementInvokeResponses) {
        this.mapElementInvokeResponses = MoreObjects.firstNonNull(mapElementInvokeResponses, new ArrayList<MapElementInvokeResponse>());
    }

    public VoteResponse getVoteResponse() {
        return voteResponse;
    }

    public void setVoteResponse(VoteResponse voteResponse) {
        this.voteResponse = voteResponse;
    }

    public StateLog getStateLog() {
        return stateLog;
    }

    public void setStateLog(StateLog stateLog) {
        this.stateLog = stateLog;
    }

    public List<EngineValue> getPreCommitStateValues() {
        return preCommitStateValues;
    }

    public void setPreCommitStateValues(List<EngineValue> preCommitStateValues) {
        this.preCommitStateValues = MoreObjects.firstNonNull(preCommitStateValues, new ArrayList<EngineValue>());
    }

    public List<EngineValue> getStateValues() {
        return stateValues;
    }

    public void setStateValues(List<EngineValue> stateValues) {
        this.stateValues = MoreObjects.firstNonNull(stateValues, new ArrayList<EngineValue>());
    }

    public List<EngineValue> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<EngineValue> outputs) {
        this.outputs = MoreObjects.firstNonNull(outputs, new ArrayList<EngineValue>());
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getRunFlowUri() {
        return runFlowUri;
    }

    public void setRunFlowUri(String runFlowUri) {
        this.runFlowUri = runFlowUri;
    }

    public String getJoinFlowUri() {
        return joinFlowUri;
    }

    public void setJoinFlowUri(String joinFlowUri) {
        this.joinFlowUri = joinFlowUri;
    }

    public EngineAuthorizationContext getAuthorizationContext() {
        return authorizationContext;
    }

    public void setAuthorizationContext(EngineAuthorizationContext authorizationContext) {
        this.authorizationContext = authorizationContext;
    }

    public List<NavigationElementReference> getNavigationElementReferences() {
        return navigationElementReferences;
    }

    public void setNavigationElementReferences(List<NavigationElementReference> navigationElementReferences) {
        this.navigationElementReferences = MoreObjects.firstNonNull(navigationElementReferences, new ArrayList<NavigationElementReference>());
    }
}
