package com.manywho.sdk.api.run.state;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.run.PropertyAware;
import com.manywho.sdk.api.run.elements.type.MObject;

import java.util.List;
import java.util.UUID;

public class StateValue implements PropertyAware {
    private UUID valueElementId;
    private String valueElementDeveloperName;
    private List<MObject> objectData = Lists.newArrayList();
    private String contentValue;
    private ContentType contentType;

    public UUID getValueElementId() {
        return valueElementId;
    }

    public void setValueElementId(UUID valueElementId) {
        this.valueElementId = valueElementId;
    }

    public String getValueElementDeveloperName() {
        return valueElementDeveloperName;
    }

    public void setValueElementDeveloperName(String valueElementDeveloperName) {
        this.valueElementDeveloperName = valueElementDeveloperName;
    }

    public List<MObject> getObjectData() {
        return objectData;
    }

    public void setObjectData(List<MObject> objectData) {
        this.objectData = MoreObjects.firstNonNull(objectData, Lists.newArrayList());
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
