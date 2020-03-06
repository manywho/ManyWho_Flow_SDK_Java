package com.manywho.sdk.api.run.state;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StateListenerRequest {
    private String listenType;
    private UUID stateId;
    private String callbackUri;
    private Map<String, String> annotations = Maps.newHashMap();

    public String getListenType() {
        return listenType;
    }

    public void setListenType(String listenType) {
        this.listenType = listenType;
    }

    public UUID getStateId() {
        return stateId;
    }

    public void setStateId(UUID stateId) {
        this.stateId = stateId;
    }

    public String getCallbackUri() {
        return callbackUri;
    }

    public void setCallbackUri(String callbackUri) {
        this.callbackUri = callbackUri;
    }

    public Map<String, String> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = MoreObjects.firstNonNull(annotations, new HashMap<String, String>());
    }
}
