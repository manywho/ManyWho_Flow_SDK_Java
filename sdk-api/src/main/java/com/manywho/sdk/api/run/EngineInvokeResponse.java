package com.manywho.sdk.api.run;

import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.elements.map.MapElementInvokeResponse;
import com.manywho.sdk.api.run.elements.map.VoteResponse;
import com.manywho.sdk.api.run.elements.ui.NavigationElementReference;
import com.manywho.sdk.api.run.state.StateLog;
import com.manywho.sdk.api.translate.Culture;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.List;

public class EngineInvokeResponse {
    private Culture culture;
    private String stateId;
    private String parentStateId;
    private String stateToken;
    private String alertEmail;
    private String waitMessage;
    private String notAuthorizedMessage;
    private String currentMapElementId;
    private String currentStreamId;
    private InvokeType invokeType;
    private HashMap<String, String> annotations;
    private List<MapElementInvokeResponse> mapElementInvokeResponses;
    private VoteResponse voteResponse;
    private StateLog stateLog;
    private List<EngineValue> preCommitStateValues;
    private List<EngineValue> stateValues;
    private List<EngineValue> outputs;
    private String statusCode;
    private String runFlowUri;
    private String joinFlowUri;
    private EngineAuthorizationContext authorizationContext;
    private List<NavigationElementReference> navigationElementReferences;

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getParentStateId() {
        return parentStateId;
    }

    public void setParentStateId(String parentStateId) {
        this.parentStateId = parentStateId;
    }

    public String getStateToken() {
        return stateToken;
    }

    public void setStateToken(String stateToken) {
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

    public String getCurrentMapElementId() {
        return currentMapElementId;
    }

    public void setCurrentMapElementId(String currentMapElementId) {
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

    public HashMap<String, String> getAnnotations() {
        return annotations;
    }

    public boolean hasAnnotations() {
        return MapUtils.isNotEmpty(annotations);
    }

    public void setAnnotations(HashMap<String, String> annotations) {
        this.annotations = annotations;
    }

    public List<MapElementInvokeResponse> getMapElementInvokeResponses() {
        return mapElementInvokeResponses;
    }

    public boolean hasMapElementInvokeResponses() {
        return CollectionUtils.isNotEmpty(mapElementInvokeResponses);
    }

    public void setMapElementInvokeResponses(List<MapElementInvokeResponse> mapElementInvokeResponses) {
        this.mapElementInvokeResponses = mapElementInvokeResponses;
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
        this.preCommitStateValues = preCommitStateValues;
    }

    public List<EngineValue> getStateValues() {
        return stateValues;
    }

    public void setStateValues(List<EngineValue> stateValues) {
        this.stateValues = stateValues;
    }

    public List<EngineValue> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<EngineValue> outputs) {
        this.outputs = outputs;
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
        this.navigationElementReferences = navigationElementReferences;
    }
}
