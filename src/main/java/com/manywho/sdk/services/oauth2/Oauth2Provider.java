package com.manywho.sdk.services.oauth2;

public interface Oauth2Provider {
    public String getName();
    public String getClientIdValueName();
    public String getClientSecretValueName();
    public String getAuthorizeUrl();
    public String getTokenUrl();
    public String[] getScopes();
    public String getAuthorizationUrl(String clientId);
    public String getAuthorizationUrl(String clientId, String responseType);
    public String getAuthorizationUrl(String clientId, String responseType, String redirectUri);
}
