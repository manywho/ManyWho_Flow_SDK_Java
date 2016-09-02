package com.manywho.sdk.api.run.elements.config;

import com.manywho.sdk.api.translate.Culture;
import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.UUID;

public abstract class AbstractResponse {
    protected String token;
    protected UUID tenantId;
    protected Culture culture;
    protected HashMap<String, String> annotations;

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

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
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
