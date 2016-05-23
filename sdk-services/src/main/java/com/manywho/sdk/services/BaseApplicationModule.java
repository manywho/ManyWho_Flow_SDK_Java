package com.manywho.sdk.services;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;
import com.manywho.sdk.api.security.AuthenticatedWho;
import com.manywho.sdk.services.providers.AuthenticatedWhoProvider;
import com.manywho.sdk.services.providers.ReflectionsProvider;
import com.manywho.sdk.services.providers.ServletContainerProvider;
import org.glassfish.jersey.servlet.ServletContainer;
import org.reflections.Reflections;

public class BaseApplicationModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AuthenticatedWho.class).toProvider(AuthenticatedWhoProvider.class);
        bind(Reflections.class).toProvider(ReflectionsProvider.class).asEagerSingleton();
        bind(ServletContainer.class).toProvider(ServletContainerProvider.class).in(Scopes.SINGLETON);

        install(new ServletModule() {
            @Override
            protected void configureServlets() {
                serve("/*").with(ServletContainer.class);
            }
        });
    }
}
