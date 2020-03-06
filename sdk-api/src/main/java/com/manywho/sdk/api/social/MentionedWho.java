package com.manywho.sdk.api.social;

public class MentionedWho {
    private String id;
    private String name;
    private String fullName;
    private String jobTitle;
    private String avatarUrl;

    public String getId() {
        return id;
    }

    public MentionedWho setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MentionedWho setName(String name) {
        this.name = name;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public MentionedWho setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public MentionedWho setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public MentionedWho setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }
}
