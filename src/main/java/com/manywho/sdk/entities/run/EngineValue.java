package com.manywho.sdk.entities.run;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.manywho.sdk.entities.run.elements.type.ObjectCollection;
import com.manywho.sdk.enums.ContentType;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EngineValue {
    private String valueElementId;
    private String typeElementId;
    private String typeElementPropertyId;
    private String developerName;
    private String typeElementDeveloperName;
    private String typeElementPropertyDeveloperName;
    private String contentValue;
    private ContentType contentType;
    private ObjectCollection objectData;

    public EngineValue() {

    }

    public EngineValue(String developerName, ContentType contentType, String contentValue) {
        this.developerName = developerName;
        this.contentType = contentType;
        this.contentValue = contentValue;
    }

    public EngineValue(String developerName, ContentType contentType, ObjectCollection objectData) {
        this.developerName = developerName;
        this.contentType = contentType;
        this.objectData = objectData;
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

    public ObjectCollection getObjectData() {
        return objectData;
    }

    public void setObjectData(ObjectCollection objectData) {
        this.objectData = objectData;
    }
}
