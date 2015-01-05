package com.manywho.sdk.entities.run.elements.ui;

import com.manywho.sdk.entities.run.EngineValueCollection;

public class PageContainerDataResponse {
    private String pageContainerId;
    private boolean isEnabled;
    private boolean isEditable;
    private boolean isVisible;
    private EngineValueCollection tags;

    public String getPageContainerId() {
        return pageContainerId;
    }

    public void setPageContainerId(String pageContainerId) {
        this.pageContainerId = pageContainerId;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public boolean isEditable() {
        return isEditable;
    }

    public void setEditable(boolean isEditable) {
        this.isEditable = isEditable;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public EngineValueCollection getTags() {
        return tags;
    }

    public void setTags(EngineValueCollection tags) {
        this.tags = tags;
    }
}
