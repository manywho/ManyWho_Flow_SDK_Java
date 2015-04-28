package com.manywho.sdk.entities.run.elements.type;

import com.manywho.sdk.entities.run.Request;
import com.manywho.sdk.entities.translate.Culture;
import com.manywho.sdk.entities.draw.content.Command;
import com.manywho.sdk.entities.run.EngineValueCollection;
import com.manywho.sdk.entities.run.elements.config.Authorization;
import org.apache.commons.collections4.CollectionUtils;

import javax.validation.constraints.NotNull;
import java.lang.*;

public class ObjectDataRequest implements Request {
    private String stateId;
    private String token;
    private String typeElementBindingId;
    @NotNull
    private Authorization authorization;
    private EngineValueCollection configurationValues;
    private Command command;
    private Culture culture;
    private ListFilter listFilter;
    private ObjectDataType objectDataType;
    private ObjectCollection objectData;

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

    public boolean hasConfigurationValues() {
        return CollectionUtils.isNotEmpty(configurationValues);
    }

    public void setConfigurationValues(EngineValueCollection configurationValues) {
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

    public ObjectCollection getObjectData() {
        return objectData;
    }

    public void setObjectData(ObjectCollection objectData) {
        this.objectData = objectData;
    }
}
