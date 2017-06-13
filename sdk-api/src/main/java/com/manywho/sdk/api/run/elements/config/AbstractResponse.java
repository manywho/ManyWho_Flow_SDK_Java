package com.manywho.sdk.api.run.elements.config;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Maps;
import com.manywho.sdk.api.translate.Culture;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class AbstractResponse {
    protected String token;
    protected UUID tenantId;
    protected Culture culture;
    protected Map<String, String> annotations = Maps.newHashMap();

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
