package com.manywho.sdk.api.run.elements.ui;

import com.manywho.sdk.api.run.EngineValue;
import org.apache.commons.collections4.CollectionUtils;

import java.util.HashMap;
import java.util.List;

public class PageResponse {
    private String label;
    private List<PageContainerResponse> pageContainerResponses;
    private List<PageComponentResponse> pageComponentResponses;
    private List<PageComponentDataResponse> pageComponentDataResponses;
    private List<PageContainerDataResponse> pageContainerDataResponses;
    private List<EngineValue> tags;
    private HashMap<String, String> attributes;
    private int order;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<PageContainerResponse> getPageContainerResponses() {
        return pageContainerResponses;
    }

    public boolean hasPageContainerResponses() {
        return CollectionUtils.isNotEmpty(pageContainerResponses);
    }

    public void setPageContainerResponses(List<PageContainerResponse> pageContainerResponses) {
        this.pageContainerResponses = pageContainerResponses;
    }

    public List<PageComponentResponse> getPageComponentResponses() {
        return pageComponentResponses;
    }

    public boolean hasPageComponentResponses() {
        return CollectionUtils.isNotEmpty(pageComponentResponses);
    }

    public void setPageComponentResponses(List<PageComponentResponse> pageComponentResponses) {
        this.pageComponentResponses = pageComponentResponses;
    }

    public List<PageComponentDataResponse> getPageComponentDataResponses() {
        return pageComponentDataResponses;
    }

    public boolean hasPageComponentDataResponses() {
        return CollectionUtils.isNotEmpty(pageComponentDataResponses);
    }

    public void setPageComponentDataResponses(List<PageComponentDataResponse> pageComponentDataResponses) {
        this.pageComponentDataResponses = pageComponentDataResponses;
    }

    public List<PageContainerDataResponse> getPageContainerDataResponses() {
        return pageContainerDataResponses;
    }

    public boolean hasPageContainerDataResponses() {
        return CollectionUtils.isNotEmpty(pageContainerDataResponses);
    }

    public void setPageContainerDataResponses(List<PageContainerDataResponse> pageContainerDataResponses) {
        this.pageContainerDataResponses = pageContainerDataResponses;
    }

    public List<EngineValue> getTags() {
        return tags;
    }

    public void setTags(List<EngineValue> tags) {
        this.tags = tags;
    }

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<String, String> attributes) {
        this.attributes = attributes;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
