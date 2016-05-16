package com.manywho.sdk.api.draw.elements.type;

import java.util.List;

public class TypeElementBinding {
    private String id;
    private String developerName;
    private String developerSummary;
    private String databaseTableName;
    private String serviceElementId;
    private List<TypeElementPropertyBinding> propertyBindings;

    public TypeElementBinding(String id, String developerName, String developerSummary, String databaseTableName, String serviceElementId, List<TypeElementPropertyBinding> propertyBindings) {
        this.id = id;
        this.developerName = developerName;
        this.developerSummary = developerSummary;
        this.databaseTableName = databaseTableName;
        this.serviceElementId = serviceElementId;
        this.propertyBindings = propertyBindings;
    }

    public TypeElementBinding(String developerName, String developerSummary, String databaseTableName, List<TypeElementPropertyBinding> propertyBindings) {
        this(null, developerName, developerSummary, databaseTableName, null, propertyBindings);
    }

    public TypeElementBinding(String developerName, String developerSummary, String databaseTableName) {
        this(null, developerName, developerSummary, databaseTableName, null, null);
    }

    public TypeElementBinding() {
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

    public List<TypeElementPropertyBinding> getPropertyBindings() {
        return propertyBindings;
    }

    public void setPropertyBindings(List<TypeElementPropertyBinding> propertyBindings) {
        this.propertyBindings = propertyBindings;
    }
}
