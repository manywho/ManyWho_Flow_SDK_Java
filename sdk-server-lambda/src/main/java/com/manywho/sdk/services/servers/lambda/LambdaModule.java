package com.manywho.sdk.services.servers.lambda;

import com.google.inject.AbstractModule;
import com.manywho.sdk.api.security.AuthenticatedWho;

public class LambdaModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AuthenticatedWho.class).toProvider(LambdaContext::getUser);
    }
}
