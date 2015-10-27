package com.manywho.sdk.entities.social;

public class Attachment {
    private String name;
    private String iconUrl;
    private String downloadUrl;
    private String size;
    private String description;
    private String type;

    public String getName() {
        return name;
    }

    public Attachment setName(String name) {
        this.name = name;
        return this;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public Attachment setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public Attachment setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
        return this;
    }

    public String getSize() {
        return size;
    }

    public Attachment setSize(String size) {
        this.size = size;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Attachment setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getType() {
        return type;
    }

    public Attachment setType(String type) {
        this.type = type;
        return this;
    }
}
