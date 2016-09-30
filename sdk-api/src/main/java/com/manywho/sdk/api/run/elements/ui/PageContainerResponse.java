package com.manywho.sdk.api.run.elements.ui;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PageContainerResponse {
    private UUID id;
    private String containerType;
    private String developerName;
    private String label;
    private List<PageContainerResponse> pageContainerResponses = Lists.newArrayList();
    private int order;
    private Map<String, String> attributes = Maps.newHashMap();

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
        this.pageContainerResponses = MoreObjects.firstNonNull(pageContainerResponses, Lists.newArrayList());
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = MoreObjects.firstNonNull(attributes, Maps.newHashMap());
    }
}
