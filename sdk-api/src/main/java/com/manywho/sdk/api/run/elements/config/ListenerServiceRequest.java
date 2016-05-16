package com.manywho.sdk.api.run.elements.config;

import com.manywho.sdk.api.run.EngineValue;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class ListenerServiceRequest extends AbstractRequest {
    @NotBlank
    private String listenType;
    @NotNull
    private EngineValue valueForListening;

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
}
