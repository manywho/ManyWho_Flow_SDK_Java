package com.manywho.sdk.api.run.elements.config;

import com.manywho.sdk.api.run.EngineValue;

public class ListenerServiceResponse extends AbstractResponse {
    private EngineValue listeningEventValue;

    public EngineValue getListeningEventValue() {
        return listeningEventValue;
    }

    public void setListeningEventValue(EngineValue listeningEventValue) {
        this.listeningEventValue = listeningEventValue;
    }
}
