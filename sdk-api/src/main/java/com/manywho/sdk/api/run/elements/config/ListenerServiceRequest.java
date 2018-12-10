package com.manywho.sdk.api.run.elements.config;

import com.manywho.sdk.api.run.EngineValue;

public class ListenerServiceRequest extends AbstractRequest {
    private String listenType;
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
