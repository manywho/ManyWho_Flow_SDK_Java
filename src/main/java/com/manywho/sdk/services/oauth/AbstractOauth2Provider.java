package com.manywho.sdk.services.oauth;

import org.scribe.builder.api.DefaultApi20;

public abstract class AbstractOauth2Provider extends DefaultApi20 implements OauthProvider {
    public abstract String getName();
}
