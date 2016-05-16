package com.manywho.sdk.services.providers;

import com.google.inject.Provider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class ServletContainerProvider implements Provider<ServletContainer> {

    private final ResourceConfig app;

    @javax.inject.Inject
    ServletContainerProvider(ResourceConfig app) {
        this.app = app;
    }

    @Override
    public ServletContainer get() {
        return new ServletContainer(app);
    }
}
