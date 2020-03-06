package com.manywho.sdk.api.draw.elements.type;

import com.manywho.sdk.api.ContentType;

import java.util.UUID;

public class TypeElementProperty implements Comparable<TypeElementProperty> {
    private UUID id;
    private String developerName;
    private String contentFormat;
    private ContentType contentType;
    private UUID typeElementId;
    private String typeElementDeveloperName;

    public TypeElementProperty(UUID id, String developerName, ContentType contentType, UUID typeElementId, String typeElementDeveloperName) {
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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public UUID getTypeElementId() {
        return typeElementId;
    }

    public void setTypeElementId(UUID typeElementId) {
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
        return getDeveloperName().compareTo(typeElementProperty.getDeveloperName());
    }
}
