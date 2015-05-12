package com.manywho.sdk.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.services.factories.ConfigurationValuesFactory;
import com.manywho.sdk.services.providers.ConfigurationValuesFactoryProvider;
import com.manywho.sdk.services.providers.ObjectMapperProvider;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.spi.internal.ValueFactoryProvider;

import javax.inject.Singleton;

public class ServiceBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bindFactory(ObjectMapperProvider.class).to(ObjectMapper.class).ranked(1);

        bind(ObjectBuilder.class).to(ObjectBuilder.class).in(Singleton.class);
        bind(PropertyCollectionParser.class).to(PropertyCollectionParser.class).in(Singleton.class);

        bind(DefaultServiceInformation.class).to(ServiceInformation.class).ranked(1);

        bind(ConfigurationValuesFactoryProvider.class).to(ValueFactoryProvider.class).in(Singleton.class);
        bind(ConfigurationValuesFactory.class).to(ConfigurationValuesFactory.class).in(Singleton.class);
    }
}
