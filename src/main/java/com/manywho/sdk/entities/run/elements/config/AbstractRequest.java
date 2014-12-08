package com.manywho.sdk.entities.run.elements.config;

import com.manywho.sdk.entities.draw.elements.group.GroupAuthorization;
import com.manywho.sdk.entities.run.EngineValueCollection;
import com.manywho.sdk.entities.translate.Culture;

import java.util.HashMap;

public abstract class AbstractRequest {
    protected String token;
    protected String tenantId;
    protected String callbackUri;
    protected Culture culture;
    protected EngineValueCollection configurationValues;
    protected GroupAuthorization authorization;
    protected HashMap<String, String> annotations;

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<String, String> attributes) {
        this.attributes = attributes;
    }

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

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public EngineValueCollection getConfigurationValues() {
        return configurationValues;
    }

    public void setConfigurationValues(EngineValueCollection configurationValues) {
        this.configurationValues = configurationValues;
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

    private HashMap<String, String> attributes;
}
