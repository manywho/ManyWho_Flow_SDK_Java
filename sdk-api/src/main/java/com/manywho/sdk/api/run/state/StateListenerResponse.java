package com.manywho.sdk.api.run.state;

import java.util.UUID;

public class StateListenerResponse extends StateListenerRequest {
    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
