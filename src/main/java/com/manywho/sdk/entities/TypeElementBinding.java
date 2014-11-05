package com.manywho.sdk.entities;

public class TypeElementBinding {
    private String id;
    private String developerName;
    private String developerSummary;
    private String databaseTableName;
    private String serviceElementId;
    private TypeElementPropertyBindingCollection propertyBindings;

    public TypeElementBinding(String id, String developerName, String developerSummary, String databaseTableName, String serviceElementId, TypeElementPropertyBindingCollection propertyBindings) {
        this.id = id;
        this.developerName = developerName;
        this.developerSummary = developerSummary;
        this.databaseTableName = databaseTableName;
        this.serviceElementId = serviceElementId;
        this.propertyBindings = propertyBindings;
    }

    public TypeElementBinding(String developerName, String developerSummary, String databaseTableName) {
        this(null, developerName, developerSummary, databaseTableName, null, null);
    }

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

    public String getDeveloperSummary() {
        return developerSummary;
    }

    public void setDeveloperSummary(String developerSummary) {
        this.developerSummary = developerSummary;
    }

    public String getDatabaseTableName() {
        return databaseTableName;
    }

    public void setDatabaseTableName(String databaseTableName) {
        this.databaseTableName = databaseTableName;
    }

    public String getServiceElementId() {
        return serviceElementId;
    }

    public void setServiceElementId(String serviceElementId) {
        this.serviceElementId = serviceElementId;
    }

    public TypeElementPropertyBindingCollection getPropertyBindings() {
        return propertyBindings;
    }

    public void setPropertyBindings(TypeElementPropertyBindingCollection propertyBindings) {
        this.propertyBindings = propertyBindings;
    }
}
