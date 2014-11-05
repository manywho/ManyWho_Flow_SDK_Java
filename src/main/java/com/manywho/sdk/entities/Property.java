package com.manywho.sdk.entities;

public class Property {
    private String typeElementPropertyId;
    private String developerName;
    private String contentValue;
    private ObjectCollection objectData;

    public Property(String developerName) {
        this.developerName = developerName;
    }

    public Property(String developerName, String contentValue) {
        this.developerName = developerName;
        this.contentValue = contentValue;
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
