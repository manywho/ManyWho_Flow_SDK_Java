package com.manywho.sdk.api.social;

public class File {
    private String id;
    private String name;
    private int size;
    private String type;
    private String url;
    private String deleteUrl;
    private String thumbnailUrl;
    private String deleteType;

    public String getId() {
        return id;
    }

    public File setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public File setName(String name) {
        this.name = name;
        return this;
    }

    public int getSize() {
        return size;
    }

    public File setSize(int size) {
        this.size = size;
        return this;
    }

    public String getType() {
        return type;
    }

    public File setType(String type) {
        this.type = type;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public File setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getDeleteUrl() {
        return deleteUrl;
    }

    public File setDeleteUrl(String deleteUrl) {
        this.deleteUrl = deleteUrl;
        return this;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public File setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
        return this;
    }

    public String getDeleteType() {
        return deleteType;
    }

    public File setDeleteType(String deleteType) {
        this.deleteType = deleteType;
        return this;
    }
}
