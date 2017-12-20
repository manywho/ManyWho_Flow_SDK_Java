package com.manywho.sdk.api.run.elements.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.FlowMode;
import com.manywho.sdk.api.run.elements.map.OutcomeResponse;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceRequest extends AbstractRequest {
    private String joinPlayerUri;
    private String playerUri;
    private String uri;
    private List<EngineValue> inputs = Lists.newArrayList();
    private List<OutcomeResponse> outcomes = Lists.newArrayList();
    private FlowMode executionMode;

    public String getJoinPlayerUri() {
        return joinPlayerUri;
    }

    public void setJoinPlayerUri(String joinPlayerUri) {
        this.joinPlayerUri = joinPlayerUri;
    }

    public String getPlayerUri() {
        return playerUri;
    }

    public void setPlayerUri(String playerUri) {
        this.playerUri = playerUri;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
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

    public List<OutcomeResponse> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<OutcomeResponse> outcomes) {
        this.outcomes = MoreObjects.firstNonNull(outcomes, new ArrayList<OutcomeResponse>());
    }

    public FlowMode getExecutionMode() {
        return executionMode;
    }

    public void setExecutionMode(FlowMode executionMode) {
        this.executionMode = executionMode;
    }
}
