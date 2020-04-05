package com.manywho.sdk.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.manywho.sdk.api.jackson.ObjectMapperFactory;
import com.manywho.sdk.services.actions.ActionHandler;
import com.manywho.sdk.services.actions.ActionProvider;
import com.manywho.sdk.services.actions.DummyActionHandler;
import com.manywho.sdk.services.actions.DummyActionProvider;
import com.manywho.sdk.services.configuration.ApplicationConfiguration;
import com.manywho.sdk.services.health.DummyHealthHandler;
import com.manywho.sdk.services.health.HealthHandler;
import com.manywho.sdk.services.providers.FileUploadProvider;
import com.manywho.sdk.services.providers.ReflectionsProvider;
import com.manywho.sdk.services.types.DummyTypeProvider;
import com.manywho.sdk.services.types.TypeProvider;
import org.apache.commons.fileupload.FileUpload;
import org.reflections.Reflections;

public class ServerApplicationModule extends AbstractModule {
    private final String applicationPackage;

    public ServerApplicationModule(String applicationPackage) {
        this.applicationPackage = applicationPackage;
    }

    @Override
    protected void configure() {
        bind(FileUpload.class).toProvider(FileUploadProvider.class).asEagerSingleton();
        bind(Reflections.class).toProvider(ReflectionsProvider.class).asEagerSingleton();

        bind(TypeProvider.class).to(DummyTypeProvider.class);
        bind(ActionProvider.class).to(DummyActionProvider.class);
        bind(ActionHandler.class).to(DummyActionHandler.class);
        bind(ApplicationConfiguration.class).toInstance(new ApplicationConfiguration(applicationPackage));
        bind(HealthHandler.class).to(DummyHealthHandler.class);
        bind(ObjectMapper.class).toInstance(ObjectMapperFactory.create());
    }
}
