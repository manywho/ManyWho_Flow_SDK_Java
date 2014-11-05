package com.manywho.sdk.entities;

public class TypeElement extends Element {
    private String id;
    private String serviceElementId;
    private TypeElementPropertyCollection properties;
    private TypeElementBindingCollection bindings;
    private boolean updateByName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceElementId() {
        return serviceElementId;
    }

    public void setServiceElementId(String serviceElementId) {
        this.serviceElementId = serviceElementId;
    }

    public TypeElementPropertyCollection getProperties() {
        return properties;
    }

    public void setProperties(TypeElementPropertyCollection properties) {
        this.properties = properties;
    }

    public TypeElementBindingCollection getBindings() {
        return bindings;
    }

    public void setBindings(TypeElementBindingCollection bindings) {
        this.bindings = bindings;
    }

    public boolean isUpdateByName() {
        return updateByName;
    }

    public void setUpdateByName(boolean updateByName) {
        this.updateByName = updateByName;
    }
}
