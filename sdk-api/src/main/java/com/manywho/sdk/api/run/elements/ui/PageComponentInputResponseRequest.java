package com.manywho.sdk.api.run.elements.ui;

import com.manywho.sdk.api.run.PropertyAware;
import com.manywho.sdk.api.run.elements.type.MObject;

import java.util.List;

public class PageComponentInputResponseRequest implements PropertyAware {
    private String pageComponentId;
    private String contentValue;
    private List<MObject> objectData;

    public PageComponentInputResponseRequest() {

    }

    public PageComponentInputResponseRequest(String pageComponentId) {
        this.pageComponentId = pageComponentId;
    }

    public PageComponentInputResponseRequest(String pageComponentId, List<MObject> objectData) {
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

    public List<MObject> getObjectData() {
        return objectData;
    }

    public void setObjectData(List<MObject> objectData) {
        this.objectData = objectData;
    }
}
