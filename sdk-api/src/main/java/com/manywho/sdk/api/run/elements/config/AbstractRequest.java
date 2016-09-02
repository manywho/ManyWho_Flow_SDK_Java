package com.manywho.sdk.api.run.elements.config;

import com.manywho.sdk.api.draw.elements.group.GroupAuthorization;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.ConfigurationValuesAware;
import com.manywho.sdk.api.translate.Culture;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public abstract class AbstractRequest implements ConfigurationValuesAware {
    protected String token;
    protected UUID tenantId;
    protected UUID stateId;
    protected String callbackUri;
    protected Culture culture;
    protected List<EngineValue> configurationValues;
    protected GroupAuthorization authorization;
    protected HashMap<String, String> annotations;
    private HashMap<String, String> attributes;

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public boolean hasAttributes() {
        return MapUtils.isNotEmpty(attributes);
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

    public UUID getTenantId() {
        return tenantId;
    }

    public void setTenantId(UUID tenantId) {
        this.tenantId = tenantId;
    }

    public UUID getStateId() {
        return stateId;
    }

    public void setStateId(UUID stateId) {
        this.stateId = stateId;
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

    public List<EngineValue> getConfigurationValues() {
        return configurationValues;
    }

    public boolean hasConfigurationValues() {
        return CollectionUtils.isNotEmpty(configurationValues);
    }

    public void setConfigurationValues(List<EngineValue> configurationValues) {
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

    public boolean hasAnnotations() {
        return MapUtils.isNotEmpty(annotations);
    }

    public void setAnnotations(HashMap<String, String> annotations) {
        this.annotations = annotations;
    }
}
