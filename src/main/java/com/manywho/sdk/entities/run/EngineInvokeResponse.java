package com.manywho.sdk.entities.run;

import com.manywho.sdk.entities.run.elements.map.MapElementInvokeResponseCollection;
import com.manywho.sdk.entities.run.elements.map.VoteResponse;
import com.manywho.sdk.entities.run.elements.ui.NavigationElementReferenceCollection;
import com.manywho.sdk.entities.run.state.StateLog;
import com.manywho.sdk.entities.translate.Culture;
import com.manywho.sdk.enums.InvokeType;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;

public class EngineInvokeResponse implements Response {
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
    private MapElementInvokeResponseCollection mapElementInvokeResponses;
    private VoteResponse voteResponse;
    private StateLog stateLog;
    private EngineValueCollection preCommitStateValues;
    private EngineValueCollection stateValues;
    private EngineValueCollection outputs;
    private String statusCode;
    private String runFlowUri;
    private String joinFlowUri;
    private EngineAuthorizationContext authorizationContext;
    private NavigationElementReferenceCollection navigationElementReferences;

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

    public MapElementInvokeResponseCollection getMapElementInvokeResponses() {
        return mapElementInvokeResponses;
    }

    public boolean hasMapElementInvokeResponses() {
        return CollectionUtils.isNotEmpty(mapElementInvokeResponses);
    }

    public void setMapElementInvokeResponses(MapElementInvokeResponseCollection mapElementInvokeResponses) {
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

    public EngineValueCollection getPreCommitStateValues() {
        return preCommitStateValues;
    }

    public void setPreCommitStateValues(EngineValueCollection preCommitStateValues) {
        this.preCommitStateValues = preCommitStateValues;
    }

    public EngineValueCollection getStateValues() {
        return stateValues;
    }

    public void setStateValues(EngineValueCollection stateValues) {
        this.stateValues = stateValues;
    }

    public EngineValueCollection getOutputs() {
        return outputs;
    }

    public void setOutputs(EngineValueCollection outputs) {
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

    public NavigationElementReferenceCollection getNavigationElementReferences() {
        return navigationElementReferences;
    }

    public void setNavigationElementReferences(NavigationElementReferenceCollection navigationElementReferences) {
        this.navigationElementReferences = navigationElementReferences;
    }
}
