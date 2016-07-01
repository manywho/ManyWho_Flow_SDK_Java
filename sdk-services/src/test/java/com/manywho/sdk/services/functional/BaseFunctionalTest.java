package com.manywho.sdk.services.functional;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.manywho.sdk.services.jaxrs.resolvers.ObjectMapperContextResolver;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.test.JerseyTest;

import javax.ws.rs.core.Application;

public abstract class BaseFunctionalTest extends JerseyTest {
    @Override
    protected Application configure() {
        Injector injector = Guice.createInjector();
        TestApplication application = new TestApplication(injector);
        application.initialize();

        return application;
    }

    @Override
    protected void configureClient(ClientConfig config) {
        config.register(ObjectMapperContextResolver.class);
    }
}
