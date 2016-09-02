package com.manywho.sdk.api.run.elements.type;

import java.util.List;
import java.util.UUID;

public class ObjectDataType {
    private UUID typeElementId;
    private String developerName;
    private List<ObjectDataTypeProperty> properties;

    public UUID getTypeElementId() {
        return typeElementId;
    }

    public void setTypeElementId(UUID typeElementId) {
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
