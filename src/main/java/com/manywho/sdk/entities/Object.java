package com.manywho.sdk.entities;

public class Object {
    private String internalId;
    private String externalId;
    private String developerName;
    private String typeElementId;
    private int order;
    private PropertyCollection properties;
    private boolean isSelected;

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
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

    public String getTypeElementId() {
        return typeElementId;
    }

    public void setTypeElementId(String typeElementId) {
        this.typeElementId = typeElementId;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public PropertyCollection getProperties() {
        return properties;
    }

    public void setProperties(PropertyCollection properties) {
        this.properties = properties;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
