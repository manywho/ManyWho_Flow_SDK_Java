package com.manywho.sdk.entities.run;

import com.manywho.sdk.entities.draw.flow.FlowId;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;

public class EngineInitializationRequest implements Request {
    private FlowId flowId;
    private String stateId;
    private String parentStateId;
    private String externalIdentifier;
    private HashMap<String, String> annotations;
    private EngineValueCollection inputs;
    private String playerUrl;
    private String joinPlayerUrl;
    private String mode;
    private String reportingMode;

    public FlowId getFlowId() {
        return flowId;
    }

    public void setFlowId(FlowId flowId) {
        this.flowId = flowId;
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

    public String getExternalIdentifier() {
        return externalIdentifier;
    }

    public void setExternalIdentifier(String externalIdentifier) {
        this.externalIdentifier = externalIdentifier;
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

    public EngineValueCollection getInputs() {
        return inputs;
    }

    public boolean hasInputs() {
        return CollectionUtils.isNotEmpty(inputs);
    }

    public void setInputs(EngineValueCollection inputs) {
        this.inputs = inputs;
    }

    public String getPlayerUrl() {
        return playerUrl;
    }

    public void setPlayerUrl(String playerUrl) {
        this.playerUrl = playerUrl;
    }

    public String getJoinPlayerUrl() {
        return joinPlayerUrl;
    }

    public void setJoinPlayerUrl(String joinPlayerUrl) {
        this.joinPlayerUrl = joinPlayerUrl;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getReportingMode() {
        return reportingMode;
    }

    public void setReportingMode(String reportingMode) {
        this.reportingMode = reportingMode;
    }
}
