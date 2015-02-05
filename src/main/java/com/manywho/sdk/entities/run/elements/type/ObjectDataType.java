package com.manywho.sdk.entities.run.elements.type;

public class ObjectDataType {
    private String typeElementId;
    private String developerName;
    private ObjectDataTypePropertyCollection properties;

    public String getTypeElementId() {
        return typeElementId;
    }

    public void setTypeElementId(String typeElementId) {
        this.typeElementId = typeElementId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public ObjectDataTypePropertyCollection getProperties() {
        return properties;
    }

    public void setProperties(ObjectDataTypePropertyCollection properties) {
        this.properties = properties;
    }
}
