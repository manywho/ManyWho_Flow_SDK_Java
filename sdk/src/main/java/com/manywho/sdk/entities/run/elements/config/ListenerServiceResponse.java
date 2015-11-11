package com.manywho.sdk.entities.run.elements.config;

import com.manywho.sdk.entities.run.EngineValue;

public class ListenerServiceResponse extends AbstractResponse {
    private EngineValue listeningEventValue;

    public EngineValue getListeningEventValue() {
        return listeningEventValue;
    }

    public void setListeningEventValue(EngineValue listeningEventValue) {
        this.listeningEventValue = listeningEventValue;
    }
}
