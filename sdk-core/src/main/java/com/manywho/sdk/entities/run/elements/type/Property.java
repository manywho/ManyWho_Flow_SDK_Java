package com.manywho.sdk.entities.run.elements.type;

import com.manywho.sdk.enums.ContentType;
import org.joda.time.DateTime;

import java.util.Date;

public class Property {
    private String typeElementPropertyId;
    private String developerName;
    private ContentType contentType;
    private String contentValue;
    private String contentFormat;
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

        if (contentValue instanceof MObject) {
            this.objectData = new ObjectCollection((MObject) contentValue);
        } else {
            this.contentValue = contentValue == null ? null : contentValue.toString();
        }
    }

    public Property(String developerName, Date contentValue) {
        this.developerName = developerName;
        this.contentValue = contentValue == null ? "" : new DateTime(contentValue).toDateTimeISO().toString();
    }

    public Property(String developerName, java.lang.Number contentValue) {
        this.developerName = developerName;
        this.contentValue = contentValue == null ? null : contentValue.toString();
    }

    public Property(String developerName, java.lang.Object contentValue, ContentType contentType) {
        this(developerName, contentValue);
        this.contentType = contentType;
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

    public ObjectCollection getObjectData() {
        return objectData;
    }

    public void setObjectData(ObjectCollection objectData) {
        this.objectData = objectData;
    }

    public String getContentFormat() {
        return contentFormat;
    }

    public void setContentFormat(String contentFormat) {
        this.contentFormat = contentFormat;
    }
}
