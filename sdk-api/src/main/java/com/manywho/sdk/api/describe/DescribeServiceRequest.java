package com.manywho.sdk.api.describe;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.ConfigurationValuesAware;
import com.manywho.sdk.api.translate.Culture;

import java.util.List;

public class DescribeServiceRequest implements ConfigurationValuesAware {
    private Culture culture;
    private String uri;
    private List<EngineValue> configurationValues = Lists.newArrayList();

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public List<EngineValue> getConfigurationValues() {
        return configurationValues;
    }

    @Override
    public boolean hasConfigurationValues() {
        return !configurationValues.isEmpty();
    }

    public void setConfigurationValues(List<EngineValue> configurationValues) {
        this.configurationValues = MoreObjects.firstNonNull(configurationValues, Lists.newArrayList());
    }
}
