package com.manywho.sdk.api.run.elements.type;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ObjectDataType {
    private UUID typeElementId;
    private String developerName;
    private List<ObjectDataTypeProperty> properties = Lists.newArrayList();

    public UUID getTypeElementId() {
        return typeElementId;
    }

    public ObjectDataType setTypeElementId(UUID typeElementId) {
        this.typeElementId = typeElementId;
        return this;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public ObjectDataType setDeveloperName(String developerName) {
        this.developerName = developerName;
        return this;
    }

    public List<ObjectDataTypeProperty> getProperties() {
        return properties;
    }

    public ObjectDataType setProperties(List<ObjectDataTypeProperty> properties) {
        this.properties = MoreObjects.firstNonNull(properties, new ArrayList<ObjectDataTypeProperty>());
        return this;
    }
}
