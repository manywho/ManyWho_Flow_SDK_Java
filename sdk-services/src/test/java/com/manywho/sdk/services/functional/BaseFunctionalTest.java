package com.manywho.sdk.services.functional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.manywho.sdk.services.jaxrs.resolvers.ObjectMapperContextResolver;
import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.junit.BeforeClass;

import javax.ws.rs.Path;
import java.io.IOException;

public abstract class BaseFunctionalTest {
    protected static Dispatcher dispatcher;
    protected static ObjectMapper objectMapper;

    @BeforeClass
    public static void setUp() {
        Injector injector = Guice.createInjector();

        TestApplication application = new TestApplication(injector);
        application.initialize("com.manywho.sdk.services.functional");

        objectMapper = new ObjectMapperContextResolver().getContext(null);

        dispatcher = MockDispatcherFactory.createDispatcher();

        for (Class<?> klass : application.getClasses()) {
            dispatcher.getRegistry().addPerRequestResource(klass);
        }

        dispatcher.getProviderFactory().registerProvider(ObjectMapperContextResolver.class);

        for (Object singleton : application.getSingletons()) {
            if (singleton.getClass().isAnnotationPresent(Path.class)) {
                dispatcher.getRegistry().addSingletonResource(singleton);
            } else if (singleton.getClass().getSuperclass().isAnnotationPresent(Path.class)) {
                dispatcher.getRegistry().addSingletonResource(singleton);
            }
        }
    }

    public <T> T getResponseContent(MockHttpRequest request, Class<T> aClass) {
        try {
            MockHttpResponse response = new MockHttpResponse();

            dispatcher.invoke(request, response);

            return objectMapper.readValue(response.getContentAsString(), aClass);
        } catch (IOException e) {
            throw new RuntimeException("Unable to read the response content into the type: " + aClass.getCanonicalName(), e);
        }
    }
}
