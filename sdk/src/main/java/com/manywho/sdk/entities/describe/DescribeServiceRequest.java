package com.manywho.sdk.entities.describe;

import com.manywho.sdk.entities.ConfigurationValuesAware;
import com.manywho.sdk.entities.translate.Culture;
import com.manywho.sdk.entities.run.EngineValueCollection;
import org.apache.commons.collections4.CollectionUtils;

public class DescribeServiceRequest implements ConfigurationValuesAware {
    private Culture culture;
    private String uri;
    private EngineValueCollection configurationValues;

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

    public EngineValueCollection getConfigurationValues() {
        return configurationValues;
    }

    @Override
    public boolean hasConfigurationValues() {
        return CollectionUtils.isNotEmpty(configurationValues);
    }

    public void setConfigurationValues(EngineValueCollection configurationValues) {
        this.configurationValues = configurationValues;
    }
}
