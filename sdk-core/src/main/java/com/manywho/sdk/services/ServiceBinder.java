package com.manywho.sdk.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.RunService;
import com.manywho.sdk.services.config.ServiceConfiguration;
import com.manywho.sdk.services.config.ServiceConfigurationProperties;
import com.manywho.sdk.services.factories.ReflectionsFactory;
import com.manywho.sdk.services.types.TypeBuilder;
import com.manywho.sdk.services.providers.ExceptionMapperProvider;
import com.manywho.sdk.services.providers.ObjectMapperProvider;
import com.manywho.sdk.services.types.TypeParser;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.reflections.Reflections;

import javax.inject.Singleton;

public class ServiceBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bindFactory(ObjectMapperProvider.class).to(ObjectMapper.class).ranked(1);
        bindFactory(ReflectionsFactory.class).to(Reflections.class).in(Singleton.class);

        bind(ObjectBuilder.class).to(ObjectBuilder.class).in(Singleton.class);
        bind(PropertyCollectionParser.class).to(PropertyCollectionParser.class).in(Singleton.class);

        bind(DefaultServiceInformation.class).to(ServiceInformation.class).ranked(1);

        bind(TypeBuilder.class).to(TypeBuilder.class).in(Singleton.class);
        bind(TypeParser.class).to(TypeParser.class).in(Singleton.class);

        bind(ServiceConfigurationProperties.class).to(ServiceConfiguration.class).ranked(1);

        bind(ExceptionMapperProvider.class).to(ExceptionMapperProvider.class);

        bind(RunService.class).to(RunService.class);
    }
}
