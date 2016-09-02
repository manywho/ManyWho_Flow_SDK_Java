package com.manywho.sdk.api.run.elements.type;

import com.manywho.sdk.api.draw.content.Command;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.ConfigurationValuesAware;
import com.manywho.sdk.api.run.elements.config.Authorization;
import com.manywho.sdk.api.translate.Culture;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.UUID;

public class ObjectDataRequest implements ConfigurationValuesAware {
    private UUID stateId;
    private String token;
    private UUID typeElementBindingId;
    private Authorization authorization;
    private List<EngineValue> configurationValues;
    private Command command;
    private Culture culture;
    private ListFilter listFilter;
    private ObjectDataType objectDataType;
    private List<MObject> objectData;

    public UUID getStateId() {
        return stateId;
    }

    public void setStateId(UUID stateId) {
        this.stateId = stateId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UUID getTypeElementBindingId() {
        return typeElementBindingId;
    }

    public void setTypeElementBindingId(UUID typeElementBindingId) {
        this.typeElementBindingId = typeElementBindingId;
    }

    public Authorization getAuthorization() {
        return authorization;
    }

    public void setAuthorization(Authorization authorization) {
        this.authorization = authorization;
    }

    public List<EngineValue> getConfigurationValues() {
        return configurationValues;
    }

    public boolean hasConfigurationValues() {
        return CollectionUtils.isNotEmpty(configurationValues);
    }

    public void setConfigurationValues(List<EngineValue> configurationValues) {
        this.configurationValues = configurationValues;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
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

    public List<MObject> getObjectData() {
        return objectData;
    }

    public void setObjectData(List<MObject> objectData) {
        this.objectData = objectData;
    }
}
