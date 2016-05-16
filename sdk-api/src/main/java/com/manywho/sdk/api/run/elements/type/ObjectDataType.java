package com.manywho.sdk.api.run.elements.type;

import java.util.List;

public class ObjectDataType {
    private String typeElementId;
    private String developerName;
    private List<ObjectDataTypeProperty> properties;

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

    public List<ObjectDataTypeProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<ObjectDataTypeProperty> properties) {
        this.properties = properties;
    }
}
