package com.manywho.sdk.entities.draw.elements.type;

import com.manywho.sdk.enums.ContentType;

public class TypeElementProperty implements Comparable<TypeElementProperty> {
    private String id;
    private String developerName;
    private String contentFormat;
    private ContentType contentType;
    private String typeElementId;
    private String typeElementDeveloperName;

    public TypeElementProperty(String id, String developerName, ContentType contentType, String typeElementId, String typeElementDeveloperName) {
        this.id = id;
        this.developerName = developerName;
        this.contentType = contentType;
        this.typeElementId = typeElementId;
        this.typeElementDeveloperName = typeElementDeveloperName;
    }

    public TypeElementProperty(String developerName, ContentType contentType, String typeElementDeveloperName) {
        this(null, developerName, contentType, null, typeElementDeveloperName);
    }

    public TypeElementProperty(String developerName, ContentType contentType) {
        this(null, developerName, contentType, null, null);
    }

    public TypeElementProperty() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getContentFormat() {
        return contentFormat;
    }

    public void setContentFormat(String contentFormat) {
        this.contentFormat = contentFormat;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public String getTypeElementId() {
        return typeElementId;
    }

    public void setTypeElementId(String typeElementId) {
        this.typeElementId = typeElementId;
    }

    public String getTypeElementDeveloperName() {
        return typeElementDeveloperName;
    }

    public void setTypeElementDeveloperName(String typeElementDeveloperName) {
        this.typeElementDeveloperName = typeElementDeveloperName;
    }

    @Override
    public int compareTo(TypeElementProperty typeElementProperty) {
        return this.getDeveloperName().compareTo(typeElementProperty.getDeveloperName());
    }
}
