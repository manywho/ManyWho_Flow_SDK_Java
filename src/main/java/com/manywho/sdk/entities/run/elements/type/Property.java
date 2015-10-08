package com.manywho.sdk.entities.run.elements.type;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Property {
    private String typeElementPropertyId;
    private String developerName;
    private String contentValue;
    private ObjectCollection objectData;

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

        if (contentValue instanceof Object) {
            this.objectData = new ObjectCollection((Object) contentValue);
        } else {
            this.contentValue = contentValue == null ? null : contentValue.toString();
        }
    }

    public Property(String developerName, Date contentValue) {
        this.developerName = developerName;
        this.contentValue = contentValue == null ? "" : new SimpleDateFormat("MM/dd/yyyy H:m:s a").format(contentValue);
    }

    public Property(String developerName, java.lang.Number contentValue) {
        this.developerName = developerName;
        this.contentValue = contentValue == null ? null : contentValue.toString();
    }

    public Property(String developerName, ObjectCollection objectData) {
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
