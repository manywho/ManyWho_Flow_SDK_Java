package com.manywho.sdk.entities.run.elements.config;

import com.manywho.sdk.entities.ConfigurationValuesAware;
import com.manywho.sdk.entities.draw.elements.group.GroupAuthorization;
import com.manywho.sdk.entities.run.EngineValueCollection;
import com.manywho.sdk.entities.run.Request;
import com.manywho.sdk.entities.translate.Culture;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.hibernate.validator.constraints.NotBlank;

import java.util.HashMap;

public abstract class AbstractRequest implements Request, ConfigurationValuesAware {
    @NotBlank
    protected String token;
    protected String tenantId;
    protected String stateId;
    protected String callbackUri;
    protected Culture culture;
    protected EngineValueCollection configurationValues;
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

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
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

    public EngineValueCollection getConfigurationValues() {
        return configurationValues;
    }

    public boolean hasConfigurationValues() {
        return CollectionUtils.isNotEmpty(configurationValues);
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

    public boolean hasAnnotations() {
        return MapUtils.isNotEmpty(annotations);
    }

    public void setAnnotations(HashMap<String, String> annotations) {
        this.annotations = annotations;
    }
}
