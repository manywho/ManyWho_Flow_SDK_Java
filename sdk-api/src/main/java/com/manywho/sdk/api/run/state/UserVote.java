package com.manywho.sdk.api.run.state;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserVote extends Geolocation {
    private String selectedOutcomeId;
    private String directoryUserId;
    @JsonProperty("manywhoUserId")
    private String manyWhoUserId;

    public String getSelectedOutcomeId() {
        return selectedOutcomeId;
    }

    public void setSelectedOutcomeId(String selectedOutcomeId) {
        this.selectedOutcomeId = selectedOutcomeId;
    }

    public String getDirectoryUserId() {
        return directoryUserId;
    }

    public void setDirectoryUserId(String directoryUserId) {
        this.directoryUserId = directoryUserId;
    }

    public String getManyWhoUserId() {
        return manyWhoUserId;
    }

    public void setManyWhoUserId(String manyWhoUserId) {
        this.manyWhoUserId = manyWhoUserId;
    }
}
