package com.manywho.sdk.entities.draw.elements.type;

public class TypeElementPropertyBinding {
    private String databaseFieldName;
    private String typeElementPropertyId;
    private String typeElementPropertyDeveloperName;
    private String databaseContentType;

    public TypeElementPropertyBinding(String typeElementPropertyDeveloperName, String databaseFieldName) {
        this.typeElementPropertyDeveloperName = typeElementPropertyDeveloperName;
        this.databaseFieldName = databaseFieldName;
    }

    public String getDatabaseFieldName() {
        return databaseFieldName;
    }

    public void setDatabaseFieldName(String databaseFieldName) {
        this.databaseFieldName = databaseFieldName;
    }

    public String getTypeElementPropertyId() {
        return typeElementPropertyId;
    }

    public void setTypeElementPropertyId(String typeElementPropertyId) {
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
}
