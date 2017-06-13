package com.manywho.sdk.api.run.elements.ui;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.PropertyAware;
import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PageComponentDataResponse implements PropertyAware {
    private UUID pageComponentId;
    @JsonProperty("isEnabled")
    private boolean enabled;
    @JsonProperty("isEditable")
    private boolean editable;
    @JsonProperty("isRequired")
    private boolean required;
    @JsonProperty("isVisible")
    private boolean visible;
    private List<MObject> objectData = Lists.newArrayList();
    private ObjectDataRequest objectDataRequest;
    private FileDataRequest fileDataRequest;
    private String contentValue;
    private String content;
    private String imageUri;
    @JsonProperty("isValid")
    private boolean valid;
    private String validationMessage;
    private List<EngineValue> tags = Lists.newArrayList();

    public UUID getPageComponentId() {
        return pageComponentId;
    }

    public void setPageComponentId(UUID pageComponentId) {
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

    public List<MObject> getObjectData() {
        return objectData;
    }

    public void setObjectData(List<MObject> objectData) {
        this.objectData = MoreObjects.firstNonNull(objectData, new ArrayList<MObject>());
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

    public List<EngineValue> getTags() {
        return tags;
    }

    public void setTags(List<EngineValue> tags) {
        this.tags = MoreObjects.firstNonNull(tags, new ArrayList<EngineValue>());
    }
}
