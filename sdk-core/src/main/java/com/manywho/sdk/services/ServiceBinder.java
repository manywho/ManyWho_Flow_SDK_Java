package com.manywho.sdk.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.RunService;
import com.manywho.sdk.entities.security.AuthenticatedWho;
import com.manywho.sdk.services.actions.ActionParser;
import com.manywho.sdk.services.config.RedisConfiguration;
import com.manywho.sdk.services.config.RedisConfigurationDefault;
import com.manywho.sdk.services.config.ServiceConfiguration;
import com.manywho.sdk.services.config.ServiceConfigurationDefault;
import com.manywho.sdk.services.config.ServiceConfigurationEnvironmentVariables;
import com.manywho.sdk.services.config.ServiceConfigurationProperties;
import com.manywho.sdk.services.factories.AuthenticatedWhoFactory;
import com.manywho.sdk.services.factories.JedisPoolFactory;
import com.manywho.sdk.services.factories.ObjectMapperFactory;
import com.manywho.sdk.services.factories.ReflectionsFactory;
import com.manywho.sdk.services.providers.ExceptionMapperProvider;
import com.manywho.sdk.services.types.TypeBuilder;
import com.manywho.sdk.services.types.TypeParser;
import com.manywho.sdk.validation.ServiceRequestValidator;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.reflections.Reflections;
import redis.clients.jedis.JedisPool;

import javax.inject.Singleton;

public class ServiceBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bindFactory(AuthenticatedWhoFactory.class).to(AuthenticatedWho.class).ranked(1);
        bindFactory(JedisPoolFactory.class).to(JedisPool.class).in(Singleton.class);
        bindFactory(ObjectMapperFactory.class).to(ObjectMapper.class).in(Singleton.class).ranked(1);
        bindFactory(ReflectionsFactory.class).to(Reflections.class).in(Singleton.class);

        bind(ObjectBuilder.class).to(ObjectBuilder.class).in(Singleton.class);
        bind(PropertyCollectionParser.class).to(PropertyCollectionParser.class).in(Singleton.class);

        bind(ActionParser.class).to(ActionParser.class).in(Singleton.class);
        bind(TypeBuilder.class).to(TypeBuilder.class).in(Singleton.class);
        bind(TypeParser.class).to(TypeParser.class).in(Singleton.class);

        bind(RedisConfigurationDefault.class).to(RedisConfiguration.class).in(Singleton.class).ranked(1);
        bind(ServiceConfigurationDefault.class).to(ServiceConfigurationDefault.class);
        bind(ServiceConfigurationEnvironmentVariables.class).to(ServiceConfigurationEnvironmentVariables.class);
        bind(ServiceConfigurationProperties.class).to(ServiceConfigurationProperties.class).in(Singleton.class);
        bind(ServiceConfigurationDefault.class).to(ServiceConfiguration.class).ranked(1);

        bind(ExceptionMapperProvider.class).to(ExceptionMapperProvider.class);

        bind(RunService.class).to(RunService.class);

        bind(ServiceRequestValidator.class).to(ServiceRequestValidator.class);
    }
}
