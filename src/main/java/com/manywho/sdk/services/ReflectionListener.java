package com.manywho.sdk.services;

import org.glassfish.jersey.server.monitoring.ApplicationEvent;
import org.glassfish.jersey.server.monitoring.ApplicationEventListener;
import org.glassfish.jersey.server.monitoring.RequestEvent;
import org.glassfish.jersey.server.monitoring.RequestEventListener;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

public class ReflectionListener implements ApplicationEventListener {
    @Context
    private ServletContext servletContext;

    @Override
    public void onEvent(ApplicationEvent applicationEvent) {
        switch (applicationEvent.getType()) {
            case INITIALIZATION_START:
                BaseApplication.reflections = new Reflections(new ConfigurationBuilder()
                        .addUrls(ClasspathHelper.forWebInfClasses(this.servletContext))
                        .addScanners(new MethodAnnotationsScanner())
                );
                break;
        }
    }

    @Override
    public RequestEventListener onRequest(RequestEvent requestEvent) {
        return null;
    }
}
