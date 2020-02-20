package com.manywho.sdk.services.jaxrs.resolvers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.api.jackson.ObjectMapperFactory;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {
    @Override
    public ObjectMapper getContext(Class<?> type) {
        return ObjectMapperFactory.create();
    }
}
