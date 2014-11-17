package com.manywho.sdk.entities;

import javax.validation.constraints.NotNull;

public class ObjectDataRequest {
    private String stateId;
    private String token;
    private String typeElementBindingId;
    @NotNull
    private Authorization authorization;
    private EngineValueCollection configurationValues;
    private CommandRequest command;
    private Culture culture;
    private ListFilter listFilter;
    private ObjectDataType objectDataType;
    private Object objectData;

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTypeElementBindingId() {
        return typeElementBindingId;
    }

    public void setTypeElementBindingId(String typeElementBindingId) {
        this.typeElementBindingId = typeElementBindingId;
    }

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }

    public EngineValueCollection getConfigurationValues() {
        return configurationValues;
    }

    public void setConfigurationValues(EngineValueCollection configurationValues) {
        this.configurationValues = configurationValues;
    }

    public CommandRequest getCommand() {
        return command;
    }

    public void setCommand(CommandRequest command) {
        this.command = command;
    }

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public ListFilter getListFilter() {
        return listFilter;
    }

    public void setListFilter(ListFilter listFilter) {
        this.listFilter = listFilter;
    }

    public ObjectDataType getObjectDataType() {
        return objectDataType;
    }

    public void setObjectDataType(ObjectDataType objectDataType) {
        this.objectDataType = objectDataType;
    }

    public Object getObjectData() {
        return objectData;
    }

    public void setObjectData(Object objectData) {
        this.objectData = objectData;
    }
}
