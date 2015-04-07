package com.manywho.sdk.services.factories;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.entities.run.EngineValueCollection;
import com.manywho.sdk.services.AbstractConfigurationValues;
import com.manywho.sdk.services.CachedData;
import org.glassfish.jersey.server.internal.inject.AbstractContainerRequestValueFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ConfigurationValuesFactory<T> extends AbstractContainerRequestValueFactory<AbstractConfigurationValues> {
    @Inject
    private ObjectMapper objectMapper;

    private Class<? extends AbstractConfigurationValues> classType;

    public ConfigurationValuesFactory setClassType(Class<? extends AbstractConfigurationValues> classType) {
        this.classType = classType;

        return this;
    }

    @Override
    public AbstractConfigurationValues provide() {

        try {
            JsonNode jsonBody = objectMapper.readTree(CachedData.bodyStream);
            if (jsonBody.has("configurationValues")) {
                EngineValueCollection configurationValues = objectMapper.treeToValue(jsonBody.findValue("configurationValues"), EngineValueCollection.class);

                if (configurationValues != null) {
                    return this.classType.newInstance().populate(configurationValues);
                }
            }

            return this.classType.newInstance();
        } catch (Exception ignored) {}

        return null;
    }
}
