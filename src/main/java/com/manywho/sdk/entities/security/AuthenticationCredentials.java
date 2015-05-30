package com.manywho.sdk.entities.security;

import com.manywho.sdk.entities.ConfigurationValuesAware;
import com.manywho.sdk.entities.run.EngineValueCollection;
import com.manywho.sdk.entities.run.Request;
import com.manywho.sdk.enums.AuthorizationType;
import org.apache.commons.collections4.CollectionUtils;

import javax.validation.constraints.NotNull;

public class AuthenticationCredentials implements Request, ConfigurationValuesAware {
    @NotNull
    private EngineValueCollection configurationValues;
    private AuthorizationType authenticationType;
    private String username;
    private String password;
    private String token;
    private String code;
    private String sessionToken;
    private String sessionUrl;
    private String loginUrl;
    private String redirectUri;
    private String instanceUrl;

    public EngineValueCollection getConfigurationValues() {
        return configurationValues;
    }

    @Override
    public boolean hasConfigurationValues() {
        return CollectionUtils.isNotEmpty(configurationValues);
    }

    public void setConfigurationValues(EngineValueCollection configurationValues) {
        this.configurationValues = configurationValues;
    }

    public AuthorizationType getAuthenticationType() {
        return authenticationType;
    }

    public void setAuthenticationType(AuthorizationType authenticationType) {
        this.authenticationType = authenticationType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getSessionUrl() {
        return sessionUrl;
    }

    public void setSessionUrl(String sessionUrl) {
        this.sessionUrl = sessionUrl;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getInstanceUrl() {
        return instanceUrl;
    }

    public void setInstanceUrl(String instanceUrl) {
        this.instanceUrl = instanceUrl;
    }
}
