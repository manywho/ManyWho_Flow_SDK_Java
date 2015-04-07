package com.manywho.sdk.services.features;

import com.manywho.sdk.services.annotations.ConfigurationValues;
import com.manywho.sdk.services.interceptors.BodyReaderInterceptor;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.Parameter;

@Provider
public class BodyReaderFeature implements DynamicFeature {
    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        Parameter[] parameters = resourceInfo.getResourceMethod().getParameters();
        for (Parameter parameter : parameters) {
            if (parameter.isAnnotationPresent(ConfigurationValues.class)) {
                context.register(BodyReaderInterceptor.class);
            }
        }
    }
}
