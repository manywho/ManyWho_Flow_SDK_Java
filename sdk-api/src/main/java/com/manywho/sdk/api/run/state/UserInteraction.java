package com.manywho.sdk.api.run.state;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class UserInteraction extends Geolocation {
    @JsonProperty("manywhoUserId")
    private UUID manyWhoUserId;

    public UUID getManyWhoUserId() {
        return manyWhoUserId;
    }

    public void setManyWhoUserId(UUID manyWhoUserId) {
        this.manyWhoUserId = manyWhoUserId;
    }
}
