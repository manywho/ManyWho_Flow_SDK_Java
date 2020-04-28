package com.manywho.sdk.services;

import com.google.inject.AbstractModule;
import com.manywho.sdk.api.security.AuthenticatedWho;
import com.manywho.sdk.services.providers.AuthenticatedWhoProvider;
import org.jboss.resteasy.plugins.guice.RequestScoped;

public class ServiceApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AuthenticatedWho.class).toProvider(AuthenticatedWhoProvider.class).in(RequestScoped.class);
    }
}
