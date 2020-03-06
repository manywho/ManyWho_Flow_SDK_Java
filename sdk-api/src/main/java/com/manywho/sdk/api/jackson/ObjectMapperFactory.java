package com.manywho.sdk.api.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ObjectMapperFactory {
    public static ObjectMapper create() {
        return new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY)
                .enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING)
                .enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)
                .enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)
                .registerModule(new JavaTimeModule());
    }
}
