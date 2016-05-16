package com.manywho.sdk.api.run.elements.type;

import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.ConfigurationValuesAware;
import com.manywho.sdk.api.run.elements.config.Authorization;
import com.manywho.sdk.api.translate.Culture;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public class FileDataRequest implements ConfigurationValuesAware {
    private String stateId;
    private String serviceElementId;
    private String token;
    private Authorization authorization;
    private List<EngineValue> configurationValues;
    private Culture culture;
    private String resourcePath;
    private String resourceFile;
    private FileListFilter listFilter;

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getServiceElementId() {
        return serviceElementId;
    }

    public void setServiceElementId(String serviceElementId) {
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
        return CollectionUtils.isNotEmpty(configurationValues);
    }

    public void setConfigurationValues(List<EngineValue> configurationValues) {
        this.configurationValues = configurationValues;
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
