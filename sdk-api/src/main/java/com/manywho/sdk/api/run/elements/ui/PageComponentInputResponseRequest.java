package com.manywho.sdk.api.run.elements.ui;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.run.PropertyAware;
import com.manywho.sdk.api.run.elements.type.MObject;

import java.util.List;
import java.util.UUID;

public class PageComponentInputResponseRequest implements PropertyAware {
    private UUID pageComponentId;
    private String contentValue;
    private List<MObject> objectData = Lists.newArrayList();

    public PageComponentInputResponseRequest() {

    }

    public PageComponentInputResponseRequest(UUID pageComponentId) {
        this.pageComponentId = pageComponentId;
    }

    public PageComponentInputResponseRequest(UUID pageComponentId, List<MObject> objectData) {
        this.pageComponentId = pageComponentId;
        this.objectData = MoreObjects.firstNonNull(objectData, Lists.newArrayList());
    }

    public PageComponentInputResponseRequest(UUID pageComponentId, String contentValue) {

        this.pageComponentId = pageComponentId;
        this.contentValue = contentValue;
    }

    public UUID getPageComponentId() {
        return pageComponentId;
    }

    public void setPageComponentId(UUID pageComponentId) {
        this.pageComponentId = pageComponentId;
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

    public void setObjectData(List<MObject> objectData) {
        this.objectData = MoreObjects.firstNonNull(objectData, Lists.newArrayList());
    }
}
