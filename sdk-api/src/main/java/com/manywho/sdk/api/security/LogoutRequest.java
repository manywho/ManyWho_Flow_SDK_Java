package com.manywho.sdk.api.security;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.AuthorizationType;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.ConfigurationValuesAware;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LogoutRequest implements ConfigurationValuesAware {
    private List<EngineValue> configurationValues = Lists.newArrayList();
    private AuthorizationType authenticationType;
    private String code;
    private String logoutUrl;
    private UUID tenantId;

    public List<EngineValue> getConfigurationValues() {
        return configurationValues;
    }

    @Override
    public boolean hasConfigurationValues() {
        return !configurationValues.isEmpty();
    }

    public void setConfigurationValues(List<EngineValue> configurationValues) {
        this.configurationValues = MoreObjects.firstNonNull(configurationValues, new ArrayList<EngineValue>());
    }

    public AuthorizationType getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(AuthorizationType authenticationType) {
        this.authenticationType = authenticationType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    public UUID getTenantId() {
        return tenantId;
    }

    public void setTenantId(UUID tenantId) {
        this.tenantId = tenantId;
    }
}
