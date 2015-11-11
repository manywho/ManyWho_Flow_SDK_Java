package com.manywho.sdk.entities.run.state;

import com.manywho.sdk.entities.run.elements.type.ObjectCollection;
import com.manywho.sdk.enums.ContentType;

public class StateValue {
    private String valueElementId;
    private String valueElementDeveloperName;
    private ObjectCollection objectData;
    private String contentValue;
    private ContentType contentType;

    public String getValueElementId() {
        return valueElementId;
    }

    public void setValueElementId(String valueElementId) {
        this.valueElementId = valueElementId;
    }

    public String getValueElementDeveloperName() {
        return valueElementDeveloperName;
    }

    public void setValueElementDeveloperName(String valueElementDeveloperName) {
        this.valueElementDeveloperName = valueElementDeveloperName;
    }

    public ObjectCollection getObjectData() {
        return objectData;
    }

    public void setObjectData(ObjectCollection objectData) {
        this.objectData = objectData;
    }

    public String getContentValue() {
        return contentValue;
    }

    public void setContentValue(String contentValue) {
        this.contentValue = contentValue;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }
}
