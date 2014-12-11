package com.manywho.sdk.entities.run.elements.config;

import com.manywho.sdk.entities.translate.Culture;

import java.util.HashMap;

public abstract class AbstractResponse implements Response {
    protected String token;
    protected String tenantId;
    protected Culture culture;
    protected HashMap<String, String> annotations;

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

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public HashMap<String, String> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(HashMap<String, String> annotations) {
        this.annotations = annotations;
    }
}
