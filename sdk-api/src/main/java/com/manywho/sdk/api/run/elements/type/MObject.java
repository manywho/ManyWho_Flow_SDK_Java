package com.manywho.sdk.api.run.elements.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.ContentType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MObject {
    private UUID internalId;
    private String externalId;
    private String developerName;
    private UUID typeElementId;
    private int order;
    private List<Property> properties = Lists.newArrayList();
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
        this.properties = MoreObjects.firstNonNull(properties, new ArrayList<Property>());
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
        this.properties = MoreObjects.firstNonNull(properties, new ArrayList<Property>());
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public static class SimpleMObjectBuilder {
        private String developerName;
        private String externalId;
        private List<Property> properties = Lists.newArrayList();

        public SimpleMObjectBuilder setDeveloperName(String developerName) {
            this.developerName = developerName;
            return this;
        }

        public SimpleMObjectBuilder setExternalId(String externalId) {
            this.externalId = externalId;
            return this;
        }

        public SimpleMObjectBuilder addProperty(String developerName, String contentValue) {
            properties.add(new Property(developerName, contentValue));
            return this;
        }

        public SimpleMObjectBuilder addProperty(String developerName, Number contentValue) {
            properties.add(new Property(developerName, contentValue));
            return this;
        }

        public SimpleMObjectBuilder addProperty(String developerName, Object contentValue) {
            properties.add(new Property(developerName, contentValue));
            return this;
        }

        public SimpleMObjectBuilder addProperty(String developerName, String contentValue, ContentType contentType) {
            properties.add(new Property(developerName, contentValue, contentType));
            return this;
        }

        public SimpleMObjectBuilder addProperty(String developerName, List<MObject> mObjects) {
            properties.add(new Property(developerName, mObjects));
            return this;
        }

        public MObject build() {
            return new MObject(developerName, externalId, properties);
        }
    }
}
