package com.manywho.sdk.api.run.state;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInteraction extends Geolocation {
    @JsonProperty("manywhoUserId")
    private String manyWhoUserId;

    public String getManyWhoUserId() {
        return manyWhoUserId;
    }

    public void setManyWhoUserId(String manyWhoUserId) {
        this.manyWhoUserId = manyWhoUserId;
    }
}
