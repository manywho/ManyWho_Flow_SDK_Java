package com.manywho.sdk.api.run.elements.ui;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class PageContainerResponse {
    private UUID id;
    private String containerType;
    private String developerName;
    private String label;
    private List<PageContainerResponse> pageContainerResponses;
    private int order;
    private HashMap<String, String> attributes;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<PageContainerResponse> getPageContainerResponses() {
        return pageContainerResponses;
    }

    public void setPageContainerResponses(List<PageContainerResponse> pageContainerResponses) {
        this.pageContainerResponses = pageContainerResponses;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<String, String> attributes) {
        this.attributes = attributes;
    }
}
