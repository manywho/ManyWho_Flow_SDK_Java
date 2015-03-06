package com.manywho.sdk.entities.run.elements.type;

import com.manywho.sdk.entities.run.EngineValueCollection;
import com.manywho.sdk.entities.run.Request;
import com.manywho.sdk.entities.run.elements.config.Authorization;
import com.manywho.sdk.entities.translate.Culture;

public class FileDataRequest implements Request {
    private String stateId;
    private String serviceElementId;
    private String token;
    private Authorization authorization;
    private EngineValueCollection configurationValues;
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

    public EngineValueCollection getConfigurationValues() {
        return configurationValues;
    }

    public void setConfigurationValues(EngineValueCollection configurationValues) {
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
