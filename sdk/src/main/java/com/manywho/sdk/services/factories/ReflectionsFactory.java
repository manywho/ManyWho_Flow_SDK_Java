package com.manywho.sdk.services.factories;

import com.manywho.sdk.services.CachedData;
import org.glassfish.hk2.api.Factory;
import org.reflections.Reflections;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

public class ReflectionsFactory implements Factory<Reflections> {
    @Context
    private ServletContext servletContext;

    @Override
    public Reflections provide() {
        // TODO: Get rid of this static field in v2 and use DI instead
        return CachedData.reflections;
    }

    @Override
    public void dispose(Reflections reflections) {

    }
}
