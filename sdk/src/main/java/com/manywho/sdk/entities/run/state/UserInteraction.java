package com.manywho.sdk.entities.run.state;

public class UserInteraction extends Geolocation {
    private String manyWhoUserId;

    public String getManyWhoUserId() {
        return manyWhoUserId;
    }

    public void setManyWhoUserId(String manyWhoUserId) {
        this.manyWhoUserId = manyWhoUserId;
    }
}
