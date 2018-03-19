package com.manywho.sdk.services;

import com.google.inject.AbstractModule;
import com.manywho.sdk.api.security.AuthenticatedWho;
import com.manywho.sdk.services.actions.ActionHandler;
import com.manywho.sdk.services.actions.ActionProvider;
import com.manywho.sdk.services.actions.DummyActionProvider;
import com.manywho.sdk.services.actions.DummyActionHandler;
import com.manywho.sdk.services.configuration.ApplicationConfiguration;
import com.manywho.sdk.services.providers.AuthenticatedWhoProvider;
import com.manywho.sdk.services.providers.ReflectionsProvider;
import com.manywho.sdk.services.types.DummyTypeProvider;
import com.manywho.sdk.services.types.TypeProvider;
import org.jboss.resteasy.plugins.guice.RequestScoped;
import org.reflections.Reflections;

public class ServiceApplicationModule extends AbstractModule {
    private final String applicationPackage;
    private final boolean isHttp;

    public ServiceApplicationModule(String applicationPackage, boolean isHttp) {
        this.applicationPackage = applicationPackage;
        this.isHttp = isHttp;
    }

    @Override
    protected void configure() {
        bind(Reflections.class).toProvider(ReflectionsProvider.class).asEagerSingleton();

        bind(TypeProvider.class).to(DummyTypeProvider.class);
        bind(ActionProvider.class).to(DummyActionProvider.class);
        bind(ActionHandler.class).to(DummyActionHandler.class);
        bind(ApplicationConfiguration.class).toInstance(new ApplicationConfiguration(applicationPackage));

        if (isHttp) {
            bind(AuthenticatedWho.class).toProvider(AuthenticatedWhoProvider.class).in(RequestScoped.class);
        }
    }
}
