package com.manywho.sdk.services.oauth2;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

public abstract class AbstractOauth2Provider implements Oauth2Provider {
    protected String scopeSeparator = ",";

    public abstract String getName();

    public abstract String getClientIdValueName();

    public abstract String getClientSecretValueName();

    public abstract String getAuthorizeUrl();

    public abstract String getTokenUrl();

    @Override
    public String getAuthorizationUrl(String clientId) {
        return this.getAuthorizationUrl(clientId, "code", "");
    }

    @Override
    public String getAuthorizationUrl(String clientId, String responseType) {
        return this.getAuthorizationUrl(clientId, responseType, "");
    }

    @Override
    public String getAuthorizationUrl(String clientId, String responseType, String redirectUri) {
        String parameters = String.format("client_id=%s&scope=%s&response_type=%s&approval_prompt=%s",
                clientId,
                StringUtils.join(this.getScopes(), this.scopeSeparator),
                responseType,
                "auto"
        );

        return String.format("%s?%s", this.getAuthorizeUrl(), parameters);
    }

    @Override
    public String[] getScopes() {
        return new String[0];
    }
}
