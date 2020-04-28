package com.manywho.sdk.api.draw.elements.type;

import java.util.UUID;

public class TypeElementPropertyBinding implements Comparable<TypeElementPropertyBinding> {
    private String databaseFieldName;
    private UUID typeElementPropertyId;
    private String typeElementPropertyDeveloperName;
    private String databaseContentType;

    public TypeElementPropertyBinding(String typeElementPropertyDeveloperName, String databaseFieldName) {
        this.typeElementPropertyDeveloperName = typeElementPropertyDeveloperName;
        this.databaseFieldName = databaseFieldName;
    }

    public TypeElementPropertyBinding(String typeElementPropertyDeveloperName, String databaseFieldName, String databaseContentType) {
        this(typeElementPropertyDeveloperName, databaseFieldName);
        this.databaseContentType = databaseContentType;
    }

    public TypeElementPropertyBinding() {
    }

    public String getDatabaseFieldName() {
        return databaseFieldName;
    }

    public void setDatabaseFieldName(String databaseFieldName) {
        this.databaseFieldName = databaseFieldName;
    }

    public UUID getTypeElementPropertyId() {
        return typeElementPropertyId;
    }

    public void setTypeElementPropertyId(UUID typeElementPropertyId) {
        this.typeElementPropertyId = typeElementPropertyId;
    }

    public String getTypeElementPropertyDeveloperName() {
        return typeElementPropertyDeveloperName;
    }

    public void setTypeElementPropertyDeveloperName(String typeElementPropertyDeveloperName) {
        this.typeElementPropertyDeveloperName = typeElementPropertyDeveloperName;
    }

    public String getDatabaseContentType() {
        return databaseContentType;
    }

    public void setDatabaseContentType(String databaseContentType) {
        this.databaseContentType = databaseContentType;
    }

    @Override
    public int compareTo(TypeElementPropertyBinding propertyBinding) {
        return getTypeElementPropertyDeveloperName().compareTo(propertyBinding.getTypeElementPropertyDeveloperName());
    }
}
