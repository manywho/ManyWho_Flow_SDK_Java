package com.manywho.sdk.api.run;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.run.elements.type.MObject;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EngineValue implements PropertyAware {
    private String valueElementId;
    private String typeElementId;
    private String typeElementPropertyId;
    private String developerName;
    private String typeElementDeveloperName;
    private String typeElementPropertyDeveloperName;
    private String contentValue;
    private ContentType contentType;
    private List<MObject> objectData;

    public EngineValue() {

    }

    public EngineValue(String developerName, ContentType contentType) {
        this.developerName = developerName;
        this.contentType = contentType;
    }

    public EngineValue(String developerName, ContentType contentType, java.lang.Object contentValue) {
        this(developerName, contentType);

        if (contentValue != null) {
            this.contentValue = String.valueOf(contentValue);
        }
    }

    public EngineValue(String developerName, ContentType contentType, List<MObject> objectData) {
        this(developerName, contentType);
        this.objectData = objectData;
    }

    public EngineValue(String developerName, ContentType contentType, String typeElementDeveloperName, MObject object) {
        this(developerName, contentType, typeElementDeveloperName, Lists.newArrayList(object));
    }

    public EngineValue(String developerName, ContentType contentType, String typeElementDeveloperName, List<MObject> objectData) {
        this(developerName, contentType, objectData);
        this.typeElementDeveloperName = typeElementDeveloperName;
    }

    public String getValueElementId() {
        return valueElementId;
    }

    public void setValueElementId(String valueElementId) {
        this.valueElementId = valueElementId;
    }

    public String getTypeElementId() {
        return typeElementId;
    }

    public void setTypeElementId(String typeElementId) {
        this.typeElementId = typeElementId;
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

    public String getTypeElementDeveloperName() {
        return typeElementDeveloperName;
    }

    public void setTypeElementDeveloperName(String typeElementDeveloperName) {
        this.typeElementDeveloperName = typeElementDeveloperName;
    }

    public String getTypeElementPropertyDeveloperName() {
        return typeElementPropertyDeveloperName;
    }

    public void setTypeElementPropertyDeveloperName(String typeElementPropertyDeveloperName) {
        this.typeElementPropertyDeveloperName = typeElementPropertyDeveloperName;
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

    public List<MObject> getObjectData() {
        return objectData;
    }

    public void setObjectData(List<MObject> objectData) {
        this.objectData = objectData;
    }
}
