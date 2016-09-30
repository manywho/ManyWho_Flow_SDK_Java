package com.manywho.sdk.api.draw.elements.type;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.UUID;

public class TypeElementBinding {
    private UUID id;
    private String developerName;
    private String developerSummary;
    private String databaseTableName;
    private UUID serviceElementId;
    private List<TypeElementPropertyBinding> propertyBindings = Lists.newArrayList();

    public TypeElementBinding(UUID id, String developerName, String developerSummary, String databaseTableName, UUID serviceElementId, List<TypeElementPropertyBinding> propertyBindings) {
        this.id = id;
        this.developerName = developerName;
        this.developerSummary = developerSummary;
        this.databaseTableName = databaseTableName;
        this.serviceElementId = serviceElementId;
        this.propertyBindings = MoreObjects.firstNonNull(propertyBindings, Lists.newArrayList());
    }

    public TypeElementBinding(String developerName, String developerSummary, String databaseTableName, List<TypeElementPropertyBinding> propertyBindings) {
        this(null, developerName, developerSummary, databaseTableName, null, propertyBindings);
    }

    public TypeElementBinding(String developerName, String developerSummary, String databaseTableName) {
        this(null, developerName, developerSummary, databaseTableName, null, null);
    }

    public TypeElementBinding() {
    }

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

    public UUID getServiceElementId() {
        return serviceElementId;
    }

    public void setServiceElementId(UUID serviceElementId) {
        this.serviceElementId = serviceElementId;
    }

    public List<TypeElementPropertyBinding> getPropertyBindings() {
        return propertyBindings;
    }

    public void setPropertyBindings(List<TypeElementPropertyBinding> propertyBindings) {
        this.propertyBindings = MoreObjects.firstNonNull(propertyBindings, Lists.newArrayList());
    }
}
