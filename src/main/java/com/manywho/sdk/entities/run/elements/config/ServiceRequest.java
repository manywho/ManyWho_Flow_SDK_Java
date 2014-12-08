package com.manywho.sdk.entities.run.elements.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.manywho.sdk.entities.run.elements.map.OutcomeAvailableCollection;
import com.manywho.sdk.entities.run.EngineValueCollection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceRequest extends AbstractRequest {
    private String joinPlayerUri;
    private String playerUri;
    private String uri;
    private EngineValueCollection inputs;
    private OutcomeAvailableCollection outcomes;

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

    public EngineValueCollection getInputs() {
        return inputs;
    }

    public void setInputs(EngineValueCollection inputs) {
        this.inputs = inputs;
    }

    public OutcomeAvailableCollection getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(OutcomeAvailableCollection outcomes) {
        this.outcomes = outcomes;
    }
}
