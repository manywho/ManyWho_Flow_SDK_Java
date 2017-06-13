package com.manywho.sdk.api.run;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.manywho.sdk.api.draw.flow.FlowId;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class EngineInitializationRequest {
    @NotNull
    private FlowId flowId;
    private UUID stateId;
    private UUID parentStateId;
    private String externalIdentifier;
    private Map<String, String> annotations = Maps.newHashMap();
    private List<EngineValue> inputs = Lists.newArrayList();
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

    public String getExternalIdentifier() {
        return externalIdentifier;
    }

    public void setExternalIdentifier(String externalIdentifier) {
        this.externalIdentifier = externalIdentifier;
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

    public List<EngineValue> getInputs() {
        return inputs;
    }

    public boolean hasInputs() {
        return !inputs.isEmpty();
    }

    public void setInputs(List<EngineValue> inputs) {
        this.inputs = MoreObjects.firstNonNull(inputs, new ArrayList<EngineValue>());
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
