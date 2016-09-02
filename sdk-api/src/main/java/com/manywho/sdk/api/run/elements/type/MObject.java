package com.manywho.sdk.api.run.elements.type;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class MObject {
    private UUID internalId;
    private String externalId;
    private String developerName;
    private UUID typeElementId;
    private int order;
    private List<Property> properties;
    @JsonProperty("isSelected")
    private boolean selected;

    public MObject() {

    }

    public MObject(String developerName) {
        this.developerName = developerName;
    }

    public MObject(String developerName, String externalId, List<Property> properties) {
        this.developerName = developerName;
        this.externalId = externalId;
        this.properties = properties;
    }

    public UUID getInternalId() {
        return internalId;
    }

    public void setInternalId(UUID internalId) {
        this.internalId = internalId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public UUID getTypeElementId() {
        return typeElementId;
    }

    public void setTypeElementId(UUID typeElementId) {
        this.typeElementId = typeElementId;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
