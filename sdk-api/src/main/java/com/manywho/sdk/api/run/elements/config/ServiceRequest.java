package com.manywho.sdk.api.run.elements.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.map.OutcomeAvailable;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceRequest extends AbstractRequest {
    private String joinPlayerUri;
    private String playerUri;
    private String uri;
    private List<EngineValue> inputs = Lists.newArrayList();
    private List<OutcomeAvailable> outcomes = Lists.newArrayList();

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
        this.inputs = MoreObjects.firstNonNull(inputs, Lists.newArrayList());
    }

    public List<OutcomeAvailable> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(List<OutcomeAvailable> outcomes) {
        this.outcomes = MoreObjects.firstNonNull(outcomes, Lists.newArrayList());
    }
}
