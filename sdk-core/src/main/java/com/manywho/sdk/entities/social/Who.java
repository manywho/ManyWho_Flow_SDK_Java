package com.manywho.sdk.entities.social;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Who {
    private String id;
    private String avatarUrl;
    private String fullName;
    @JsonProperty("isFollower")
    private boolean follower;

    public Who() {
    }

    public Who(String id, String fullName) {
        this(id, null, fullName);
    }

    public Who(String id, String avatarUrl, String fullName) {
        this(id, avatarUrl, fullName, false);
    }

    public Who(String id, String avatarUrl, String fullName, boolean follower) {
        this.id = id;
        this.avatarUrl = avatarUrl;
        this.fullName = fullName;
        this.follower = follower;
    }

    public String getId() {
        return id;
    }

    public Who setId(String id) {
        this.id = id;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public Who setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public Who setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public boolean isFollower() {
        return follower;
    }

    public Who setFollower(boolean follower) {
        this.follower = follower;
        return this;
    }
}
