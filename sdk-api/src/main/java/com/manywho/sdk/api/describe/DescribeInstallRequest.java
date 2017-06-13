package com.manywho.sdk.api.describe;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.ConfigurationValuesAware;

import java.util.List;

public class DescribeInstallRequest implements ConfigurationValuesAware {
    private List<EngineValue> configurationValues = Lists.newArrayList();

    public List<EngineValue> getConfigurationValues() {
        return configurationValues;
    }

    @Override
    public boolean hasConfigurationValues() {
        return !configurationValues.isEmpty();
    }

    public void setConfigurationValues(List<EngineValue> configurationValues) {
        this.configurationValues = configurationValues;
    }
}
