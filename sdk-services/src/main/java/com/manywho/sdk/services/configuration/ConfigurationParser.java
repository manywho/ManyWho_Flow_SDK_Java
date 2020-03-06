package com.manywho.sdk.services.configuration;

import com.google.inject.Injector;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.ConfigurationValuesAware;
import com.manywho.sdk.services.values.ValueParser;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ConfigurationParser {
    private final Injector injector;
    private final ConfigurationRepository configurationRepository;
    private final ValueParser valueParser;

    @Inject
    public ConfigurationParser(
            Injector injector,
            ConfigurationRepository configurationRepository,
            ValueParser valueParser
    ) {
        this.injector = injector;
        this.configurationRepository = configurationRepository;
        this.valueParser = valueParser;
    }

    public <C extends Configuration> C from(ConfigurationValuesAware object, boolean checkRequired) {
        Class<C> configurationClass = getConfigurationClass();

        // Create an instance of the configuration class using Guice, so we support injections
        C configuration = injector.getInstance(configurationClass);

        // We always want at least an empty list of values, so we can check for existence even if no values were passed
        List<EngineValue> configurationValues = object.hasConfigurationValues()
                ? object.getConfigurationValues()
                : new ArrayList<>();

        // Check and populate the created instance with any provided configuration values
        Set<Field> configurationSettings = configurationRepository.findConfigurationSettings(configurationClass);

        for (Field field : configurationSettings) {
            populateConfigurationSetting(configuration, configurationValues, field, checkRequired);
        }

        return configuration;
    }

    public <C extends Configuration> C from(ConfigurationValuesAware object) {
        return from(object, true);
    }

    private <C extends Configuration> void populateConfigurationSetting(C configuration, List<EngineValue> configurationValues, Field field, boolean checkRequired) {
        Configuration.Setting annotation = field.getAnnotation(Configuration.Setting.class);

        // See if the discovered configuration setting field was sent in the request
        Optional<EngineValue> optional = configurationValues.stream()
                .filter(i -> i.getDeveloperName().equals(annotation.name()))
                .findFirst();

        // If the configuration setting was sent in the request, then we extract it and populate the configuration object
        if (optional.isPresent()) {
            valueParser.populateObjectField(configuration, field, annotation.contentType(), optional.get());
        } else {
            // If the setting is marked as required, but was not sent in then we error
            if (checkRequired && annotation.required()) {
                throw new RuntimeException("The configuration setting " + annotation.name() + " is required");
            }
        }
    }

    @SuppressWarnings("unchecked")
    private <C extends Configuration> Class<C> getConfigurationClass() {
        return (Class<C>) configurationRepository.getConfigurationClass();
    }
}
