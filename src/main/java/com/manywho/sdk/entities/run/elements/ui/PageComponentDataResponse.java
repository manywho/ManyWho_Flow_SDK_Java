package com.manywho.sdk.entities.run.elements.ui;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.manywho.sdk.entities.run.EngineValueCollection;
import com.manywho.sdk.entities.run.elements.type.FileDataRequest;
import com.manywho.sdk.entities.run.elements.type.ObjectCollection;
import com.manywho.sdk.entities.run.elements.type.ObjectDataRequest;

public class PageComponentDataResponse {
    private String pageComponentId;
    @JsonProperty("isEnabled")
    private boolean enabled;
    @JsonProperty("isEditable")
    private boolean editable;
    @JsonProperty("isRequired")
    private boolean required;
    @JsonProperty("isVisible")
    private boolean visible;
    private ObjectCollection objectData;
    private ObjectDataRequest objectDataRequest;
    private FileDataRequest fileDataRequest;
    private String contentValue;
    private String content;
    private String imageUri;
    @JsonProperty("isValid")
    private boolean valid;
    private String validationMessage;
    private EngineValueCollection tags;

    public String getPageComponentId() {
        return pageComponentId;
    }

    public void setPageComponentId(String pageComponentId) {
        this.pageComponentId = pageComponentId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.enabled = isEnabled;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean isEditable) {
        this.editable = isEditable;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean isRequired) {
        this.required = isRequired;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean isVisible) {
        this.visible = isVisible;
    }

    public ObjectCollection getObjectData() {
        return objectData;
    }

    public void setObjectData(ObjectCollection objectData) {
        this.objectData = objectData;
    }

    public ObjectDataRequest getObjectDataRequest() {
        return objectDataRequest;
    }

    public void setObjectDataRequest(ObjectDataRequest objectDataRequest) {
        this.objectDataRequest = objectDataRequest;
    }

    public FileDataRequest getFileDataRequest() {
        return fileDataRequest;
    }

    public void setFileDataRequest(FileDataRequest fileDataRequest) {
        this.fileDataRequest = fileDataRequest;
    }

    public String getContentValue() {
        return contentValue;
    }

    public void setContentValue(String contentValue) {
        this.contentValue = contentValue;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean isValid) {
        this.valid = isValid;
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(String validationMessage) {
        this.validationMessage = validationMessage;
    }

    public EngineValueCollection getTags() {
        return tags;
    }

    public void setTags(EngineValueCollection tags) {
        this.tags = tags;
    }
}
