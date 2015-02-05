package com.manywho.sdk.entities.run.elements.ui;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.manywho.sdk.entities.run.EngineValueCollection;

public class PageContainerDataResponse {
    private String pageContainerId;
    @JsonProperty("isEnabled")
    private boolean enabled;
    @JsonProperty("isEditable")
    private boolean editable;
    @JsonProperty("isVisible")
    private boolean visible;
    private EngineValueCollection tags;

    public String getPageContainerId() {
        return pageContainerId;
    }

    public void setPageContainerId(String pageContainerId) {
        this.pageContainerId = pageContainerId;
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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean isVisible) {
        this.visible = isVisible;
    }

    public EngineValueCollection getTags() {
        return tags;
    }

    public void setTags(EngineValueCollection tags) {
        this.tags = tags;
    }
}
