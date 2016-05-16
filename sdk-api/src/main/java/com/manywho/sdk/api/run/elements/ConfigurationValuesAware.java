package com.manywho.sdk.api.run.elements;

import com.manywho.sdk.api.run.EngineValue;

import java.util.List;

public interface ConfigurationValuesAware {
    List<EngineValue> getConfigurationValues();

    boolean hasConfigurationValues();
}
