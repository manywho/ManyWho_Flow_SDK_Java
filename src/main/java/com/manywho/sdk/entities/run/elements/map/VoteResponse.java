package com.manywho.sdk.entities.run.elements.map;

public class VoteResponse extends VoteRequest {
    private boolean isComplete;

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
}
