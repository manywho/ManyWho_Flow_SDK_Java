package com.manywho.sdk.api.run.elements.type;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.ConfigurationValuesAware;
import com.manywho.sdk.api.run.elements.config.Authorization;
import com.manywho.sdk.api.translate.Culture;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileDataRequest implements ConfigurationValuesAware {
    private UUID stateId;
    private UUID serviceElementId;
    private String token;
    private Authorization authorization;
    private List<EngineValue> configurationValues = Lists.newArrayList();
    private Culture culture;
    private String resourcePath;
    private String resourceFile;
    private FileListFilter listFilter;

    public UUID getStateId() {
        return stateId;
    }

    public void setStateId(UUID stateId) {
        this.stateId = stateId;
    }

    public UUID getServiceElementId() {
        return serviceElementId;
    }

    public void setServiceElementId(UUID serviceElementId) {
        this.serviceElementId = serviceElementId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    @Override
    public boolean hasConfigurationValues() {
        return !configurationValues.isEmpty();
    }

    public void setConfigurationValues(List<EngineValue> configurationValues) {
        this.configurationValues = MoreObjects.firstNonNull(configurationValues, new ArrayList<EngineValue>());
    }

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getResourceFile() {
        return resourceFile;
    }

    public void setResourceFile(String resourceFile) {
        this.resourceFile = resourceFile;
    }

    public FileListFilter getListFilter() {
        return listFilter;
    }

    public void setListFilter(FileListFilter listFilter) {
        this.listFilter = listFilter;
    }
}
