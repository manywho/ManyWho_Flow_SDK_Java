package com.manywho.sdk.entities.run.elements.ui;

import com.manywho.sdk.entities.run.elements.type.ObjectCollection;

public class PageComponentInputResponseRequest {
    private String pageComponentId;
    private String contentValue;
    private ObjectCollection objectData;

    public PageComponentInputResponseRequest() {

    }

    public PageComponentInputResponseRequest(String pageComponentId) {
        this.pageComponentId = pageComponentId;
    }

    public PageComponentInputResponseRequest(String pageComponentId, ObjectCollection objectData) {
        this.pageComponentId = pageComponentId;
        this.objectData = objectData;
    }

    public PageComponentInputResponseRequest(String pageComponentId, String contentValue) {

        this.pageComponentId = pageComponentId;
        this.contentValue = contentValue;
    }

    public String getPageComponentId() {
        return pageComponentId;
    }

    public void setPageComponentId(String pageComponentId) {
        this.pageComponentId = pageComponentId;
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

    public void setObjectData(ObjectCollection objectData) {
        this.objectData = objectData;
    }
}
