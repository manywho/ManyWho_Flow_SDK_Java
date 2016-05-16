package com.manywho.sdk.api.describe;

import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.ConfigurationValuesAware;
import com.manywho.sdk.api.translate.Culture;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public class DescribeServiceRequest implements ConfigurationValuesAware {
    private Culture culture;
    private String uri;
    private List<EngineValue> configurationValues;

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
        return CollectionUtils.isNotEmpty(configurationValues);
    }

    public void setConfigurationValues(List<EngineValue> configurationValues) {
        this.configurationValues = configurationValues;
    }
}
