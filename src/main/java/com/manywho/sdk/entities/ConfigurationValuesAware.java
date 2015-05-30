package com.manywho.sdk.entities;

import com.manywho.sdk.entities.run.EngineValueCollection;

public interface ConfigurationValuesAware {
    EngineValueCollection getConfigurationValues();
    boolean hasConfigurationValues();
}
