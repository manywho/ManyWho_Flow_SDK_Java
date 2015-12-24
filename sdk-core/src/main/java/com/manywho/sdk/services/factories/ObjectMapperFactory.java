package com.manywho.sdk.services.factories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.services.providers.ObjectMapperProvider;
import org.glassfish.hk2.api.Factory;

public class ObjectMapperFactory extends ObjectMapperProvider implements Factory<ObjectMapper> {
}
