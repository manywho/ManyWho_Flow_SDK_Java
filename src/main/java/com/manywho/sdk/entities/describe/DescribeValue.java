package com.manywho.sdk.entities.describe;

import com.manywho.sdk.enums.ContentType;

public class DescribeValue {
    private String developerName;
    private String contentValue;
    private boolean isRequired;
    private ContentType contentType;
    private String typeElementDeveloperName;
    private int ordinal;

    public DescribeValue(String developerName, ContentType contentType, boolean isRequired, String contentValue, String typeElementDeveloperName, int ordinal) {
        this.developerName = developerName;
        this.contentType = contentType;
        this.isRequired = isRequired;
        this.contentValue = contentValue;
        this.typeElementDeveloperName = typeElementDeveloperName;
        this.ordinal = ordinal;
    }

    public DescribeValue(String developerName, ContentType contentType, boolean isRequired, String contentValue, String typeElementDeveloperName) {
        this(developerName, contentType, isRequired, contentValue, typeElementDeveloperName, 0);
    }

    public DescribeValue(String developerName, ContentType contentType, boolean isRequired, String contentValue) {
        this(developerName, contentType, isRequired, contentValue, null, 0);
    }

    public DescribeValue(String developerName, ContentType contentType, boolean isRequired) {
        this(developerName, contentType, isRequired, null, null, 0);
    }

    public DescribeValue(String developerName, ContentType contentType) {
        this(developerName, contentType, false, null, null, 0);
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

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public String getTypeElementDeveloperName() {
        return typeElementDeveloperName;
    }

    public void setTypeElementDeveloperName(String typeElementDeveloperName) {
        this.typeElementDeveloperName = typeElementDeveloperName;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }
}
