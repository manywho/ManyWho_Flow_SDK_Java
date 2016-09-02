package com.manywho.sdk.api.run.elements.ui;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.manywho.sdk.api.ContentType;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PageComponentResponse {
    private String pageContainerDeveloperName;
    private UUID pageContainerId;
    private UUID id;
    private String developerName;
    private String componentType;
    private ContentType contentType;
    private String label;
    private List<PageComponentColumnResponse> columns;
    private int size;
    private int maxSize;
    private int height;
    private int width;
    private String hintValue;
    private String helpInfo;
    private int order;
    @JsonProperty("isMultiSelect")
    private boolean multiSelect;
    @JsonProperty("isSearchable")
    private boolean searchable;
    private boolean hasEvents;
    private HashMap<String, String> attributes;

    public String getPageContainerDeveloperName() {
        return pageContainerDeveloperName;
    }

    public void setPageContainerDeveloperName(String pageContainerDeveloperName) {
        this.pageContainerDeveloperName = pageContainerDeveloperName;
    }

    public UUID getPageContainerId() {
        return pageContainerId;
    }

    public void setPageContainerId(UUID pageContainerId) {
        this.pageContainerId = pageContainerId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<PageComponentColumnResponse> getColumns() {
        return columns;
    }

    public void setColumns(List<PageComponentColumnResponse> columns) {
        this.columns = columns;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getHintValue() {
        return hintValue;
    }

    public void setHintValue(String hintValue) {
        this.hintValue = hintValue;
    }

    public String getHelpInfo() {
        return helpInfo;
    }

    public void setHelpInfo(String helpInfo) {
        this.helpInfo = helpInfo;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isMultiSelect() {
        return multiSelect;
    }

    public void setMultiSelect(boolean isMultiSelect) {
        this.multiSelect = isMultiSelect;
    }

    public boolean isSearchable() {
        return searchable;
    }

    public void setSearchable(boolean isSearchable) {
        this.searchable = isSearchable;
    }

    public boolean isHasEvents() {
        return hasEvents;
    }

    public void setHasEvents(boolean hasEvents) {
        this.hasEvents = hasEvents;
    }

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<String, String> attributes) {
        this.attributes = attributes;
    }
}
