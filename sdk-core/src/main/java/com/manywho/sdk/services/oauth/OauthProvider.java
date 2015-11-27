package com.manywho.sdk.services.oauth;

public interface OauthProvider {
    public String getName();
    public String getClientId();
    public String getClientSecret();
    public String getRedirectUri();
}
