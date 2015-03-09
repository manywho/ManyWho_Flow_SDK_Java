package com.manywho.sdk.services.factories;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.entities.run.EngineValueCollection;
import com.manywho.sdk.services.AbstractConfigurationValues;
import org.glassfish.jersey.server.internal.inject.AbstractContainerRequestValueFactory;

import javax.inject.Inject;
import javax.inject.Singleton;import java.lang.Class;import java.lang.Exception;import java.lang.Override;

@Singleton
public class ConfigurationValuesFactory<T> extends AbstractContainerRequestValueFactory<AbstractConfigurationValues> {
    @Inject
    private ObjectMapper objectMapper;

    private byte[] body;

    private Class<? extends AbstractConfigurationValues> classType;

    public void setBody(byte[] body) {
        this.body = body;
    }

    public ConfigurationValuesFactory setClassType(Class<? extends AbstractConfigurationValues> classType) {
        this.classType = classType;

        return this;
    }

    @Override
    public AbstractConfigurationValues provide() {
        try {
            JsonNode jsonBody = objectMapper.readTree(body);
            if (jsonBody.has("configurationValues")) {
                EngineValueCollection configurationValues = objectMapper.treeToValue(jsonBody.findValue("configurationValues"), EngineValueCollection.class);

                return this.classType.newInstance().populate(configurationValues);
            }
        } catch (Exception ignored) {}

        return null;
    }
}
