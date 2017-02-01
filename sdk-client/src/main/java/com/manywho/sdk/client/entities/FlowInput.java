package com.manywho.sdk.client.entities;

import com.manywho.sdk.entities.run.elements.type.ObjectCollection;
import com.manywho.sdk.enums.ContentType;

public class FlowInput {
    private String name;
    private ContentType contentType;
    private String contentValue;
    private ObjectCollection objectData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public String getContentValue() {
        return contentValue;
    }

    public void setContentValue(String contentValue) {
        this.contentValue = contentValue;
    }

    public ObjectCollection getObjectData() {
        return objectData;
    }

    public boolean hasObjectData() {
        return objectData != null;
    }

    public void setObjectData(ObjectCollection objectData) {
        this.objectData = objectData;
    }
}
