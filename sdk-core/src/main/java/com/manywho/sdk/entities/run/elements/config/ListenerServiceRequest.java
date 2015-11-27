package com.manywho.sdk.entities.run.elements.config;

import com.manywho.sdk.entities.run.EngineValue;
import com.manywho.sdk.entities.run.EngineValueCollection;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class ListenerServiceRequest extends AbstractRequest {
    @NotBlank
    private String listenType;
    @NotNull
    private EngineValue valueForListening;
    @NotEmpty
    protected EngineValueCollection configurationValues;

    public String getListenType() {
        return listenType;
    }

    public void setListenType(String listenType) {
        this.listenType = listenType;
    }

    public EngineValue getValueForListening() {
        return valueForListening;
    }

    public void setValueForListening(EngineValue valueForListening) {
        this.valueForListening = valueForListening;
    }

    public EngineValueCollection getConfigurationValues() {
        return configurationValues;
    }

    public boolean hasConfigurationValues() {
        return CollectionUtils.isNotEmpty(configurationValues);
    }

    public void setConfigurationValues(EngineValueCollection configurationValues) {
        this.configurationValues = configurationValues;
    }
}
