package com.manywho.sdk.entities.describe;

import com.manywho.sdk.entities.translate.Culture;
import com.manywho.sdk.entities.run.EngineValueCollection;

public class DescribeServiceRequest {
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

    public void setConfigurationValues(EngineValueCollection configurationValues) {
        this.configurationValues = configurationValues;
    }
}
