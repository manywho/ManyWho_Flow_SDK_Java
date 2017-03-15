package com.manywho.sdk.api.run.state;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class UserVote extends Geolocation {
    private UUID selectedOutcomeId;
    private String directoryUserId;
    @JsonProperty("manywhoUserId")
    private UUID manyWhoUserId;

    public UUID getSelectedOutcomeId() {
        return selectedOutcomeId;
    }

    public void setSelectedOutcomeId(UUID selectedOutcomeId) {
        this.selectedOutcomeId = selectedOutcomeId;
    }

    public String getDirectoryUserId() {
        return directoryUserId;
    }

    public void setDirectoryUserId(String directoryUserId) {
        this.directoryUserId = directoryUserId;
    }

    public UUID getManyWhoUserId() {
        return manyWhoUserId;
    }

    public void setManyWhoUserId(UUID manyWhoUserId) {
        this.manyWhoUserId = manyWhoUserId;
    }
}
