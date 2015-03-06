package com.manywho.sdk.entities.run.state;

public class UserVote extends Geolocation {
    private String selectedOutcomeId;
    private String directoryUserId;
    private String manywhoUserId;

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

    public String getManywhoUserId() {
        return manywhoUserId;
    }

    public void setManywhoUserId(String manywhoUserId) {
        this.manywhoUserId = manywhoUserId;
    }
}
