package com.manywho.sdk.entities.run.elements.map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VoteResponse extends VoteRequest {
    @JsonProperty("isComplete")
    private boolean complete;

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean isComplete) {
        this.complete = isComplete;
    }
}
