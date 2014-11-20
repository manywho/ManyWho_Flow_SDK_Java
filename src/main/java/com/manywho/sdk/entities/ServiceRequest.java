package com.manywho.sdk.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;
import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceRequest {
    @NotNull
    private String token;
    private String tenantId;
    private String callbackUri;
    private String joinPlayerUri;
    private String playerUri;
    private Culture culture;
    private String uri;
    @NotNull
    private EngineValueCollection configurationValues;
    @NotNull
    private EngineValueCollection inputs;
    private OutcomeAvailableCollection outcomes;
    private GroupAuthorization authorization;
    private HashMap<String, String> annotations;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getCallbackUri() {
        return callbackUri;
    }

    public void setCallbackUri(String callbackUri) {
        this.callbackUri = callbackUri;
    }

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

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public EngineValueCollection getConfigurationValues() {
        return configurationValues;
    }

    public void setConfigurationValues(EngineValueCollection configurationValues) {
        this.configurationValues = configurationValues;
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

    public GroupAuthorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(GroupAuthorization authorization) {
        this.authorization = authorization;
    }

    public HashMap<String, String> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(HashMap<String, String> annotations) {
        this.annotations = annotations;
    }
}
