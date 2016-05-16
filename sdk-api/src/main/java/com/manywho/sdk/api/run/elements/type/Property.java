package com.manywho.sdk.api.run.elements.type;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.run.PropertyAware;

import java.util.List;

public class Property implements PropertyAware {
    private String typeElementPropertyId;
    private String developerName;
    private ContentType contentType;
    private String contentValue;
    private String contentFormat;
    private List<MObject> objectData;

    public Property() {

    }

    public Property(String developerName) {
        this.developerName = developerName;
    }

    public Property(String developerName, String contentValue) {
        this.developerName = developerName;
        this.contentValue = contentValue;
    }

    public Property(String developerName, java.lang.Object contentValue) {
        this.developerName = developerName;

        if (contentValue instanceof MObject) {
            this.objectData = Lists.newArrayList((MObject) contentValue);
        } else {
            this.contentValue = contentValue == null ? null : contentValue.toString();
        }
    }

    public Property(String developerName, Number contentValue) {
        this.developerName = developerName;
        this.contentValue = contentValue == null ? null : contentValue.toString();
    }

    public Property(String developerName, Object contentValue, ContentType contentType) {
        this(developerName, contentValue);
        this.contentType = contentType;
    }

    public Property(String developerName, List<MObject> objectData) {
        this.developerName = developerName;
        this.objectData = objectData;
    }

    public String getTypeElementPropertyId() {
        return typeElementPropertyId;
    }

    public void setTypeElementPropertyId(String typeElementPropertyId) {
        this.typeElementPropertyId = typeElementPropertyId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
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

    public void setObjectData(List<MObject> objectData) {
        this.objectData = objectData;
    }

    public String getContentFormat() {
        return contentFormat;
    }

    public void setContentFormat(String contentFormat) {
        this.contentFormat = contentFormat;
    }
}
