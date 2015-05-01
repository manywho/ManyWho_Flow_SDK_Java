package com.manywho.sdk.services.providers;

import com.fasterxml.jackson.databind.*;
import org.glassfish.hk2.api.Factory;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.text.SimpleDateFormat;

@Provider
public class ObjectMapperProvider implements ContextResolver<ObjectMapper>, Factory<ObjectMapper> {
    private final ObjectMapper defaultObjectMapper;

    public ObjectMapperProvider() {
        defaultObjectMapper = getObjectMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return defaultObjectMapper;
    }

    public static ObjectMapper getObjectMapper() {
        return new ObjectMapper()
                .setDateFormat(new SimpleDateFormat("MM/dd/yyyy H:m:s a"))
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES)
                .enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING)
                .enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    }

    @Override
    public ObjectMapper provide() {
        return getObjectMapper();
    }

    @Override
    public void dispose(ObjectMapper objectMapper) {
    }
}
