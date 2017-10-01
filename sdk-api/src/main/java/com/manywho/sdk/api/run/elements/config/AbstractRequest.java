package com.manywho.sdk.api.run.elements.config;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.manywho.sdk.api.draw.elements.group.GroupAuthorization;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.FlowMode;
import com.manywho.sdk.api.run.elements.ConfigurationValuesAware;
import com.manywho.sdk.api.translate.Culture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public abstract class AbstractRequest implements ConfigurationValuesAware {
    protected String token;
    protected UUID tenantId;
    protected UUID stateId;
    protected String callbackUri;
    protected Culture culture;
    protected FlowMode executionMode;
    protected List<EngineValue> configurationValues = Lists.newArrayList();
    protected GroupAuthorization authorization;
    protected Map<String, String> annotations = Maps.newHashMap();
    private Map<String, String> attributes = Maps.newHashMap();

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public boolean hasAttributes() {
        return !attributes.isEmpty();
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = MoreObjects.firstNonNull(attributes, new HashMap<String, String>());
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

    public FlowMode getExecutionMode() {
        return executionMode;
    }

    public void setExecutionMode(FlowMode executionMode) {
        this.executionMode = executionMode;
    }

    public List<EngineValue> getConfigurationValues() {
        return configurationValues;
    }

    public boolean hasConfigurationValues() {
        return !configurationValues.isEmpty();
    }

    public void setConfigurationValues(List<EngineValue> configurationValues) {
        this.configurationValues = MoreObjects.firstNonNull(configurationValues, new ArrayList<EngineValue>());
    }

    public GroupAuthorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(GroupAuthorization authorization) {
        this.authorization = authorization;
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
}
