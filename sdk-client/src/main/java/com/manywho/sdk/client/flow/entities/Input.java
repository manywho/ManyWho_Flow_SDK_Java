package com.manywho.sdk.client.flow.entities;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.run.elements.type.MObject;

import java.util.List;

public class Input {
    private String name;
    private ContentType contentType;
    private String contentValue;
    private List<MObject> objectData;

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

    public List<MObject> getObjectData() {
        return objectData;
    }

    public boolean hasObjectData() {
        return objectData != null;
    }

    public void setObjectData(List<MObject> objectData) {
        this.objectData = objectData;
    }
}
