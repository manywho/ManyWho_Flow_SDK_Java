package com.manywho.sdk.api.run.elements.ui;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.manywho.sdk.api.run.EngineValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageResponse {
    private String label;
    private List<PageContainerResponse> pageContainerResponses = Lists.newArrayList();
    private List<PageComponentResponse> pageComponentResponses = Lists.newArrayList();
    private List<PageComponentDataResponse> pageComponentDataResponses = Lists.newArrayList();
    private List<PageContainerDataResponse> pageContainerDataResponses = Lists.newArrayList();
    private List<EngineValue> tags = Lists.newArrayList();
    private Map<String, String> attributes = Maps.newHashMap();
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
        return !pageContainerResponses.isEmpty();
    }

    public void setPageContainerResponses(List<PageContainerResponse> pageContainerResponses) {
        this.pageContainerResponses = MoreObjects.firstNonNull(pageContainerResponses, new ArrayList<PageContainerResponse>());
    }

    public List<PageComponentResponse> getPageComponentResponses() {
        return pageComponentResponses;
    }

    public boolean hasPageComponentResponses() {
        return !pageComponentResponses.isEmpty();
    }

    public void setPageComponentResponses(List<PageComponentResponse> pageComponentResponses) {
        this.pageComponentResponses = MoreObjects.firstNonNull(pageComponentResponses, new ArrayList<PageComponentResponse>());
    }

    public List<PageComponentDataResponse> getPageComponentDataResponses() {
        return pageComponentDataResponses;
    }

    public boolean hasPageComponentDataResponses() {
        return !pageComponentDataResponses.isEmpty();
    }

    public void setPageComponentDataResponses(List<PageComponentDataResponse> pageComponentDataResponses) {
        this.pageComponentDataResponses = MoreObjects.firstNonNull(pageComponentDataResponses, new ArrayList<PageComponentDataResponse>());
    }

    public List<PageContainerDataResponse> getPageContainerDataResponses() {
        return pageContainerDataResponses;
    }

    public boolean hasPageContainerDataResponses() {
        return !pageContainerDataResponses.isEmpty();
    }

    public void setPageContainerDataResponses(List<PageContainerDataResponse> pageContainerDataResponses) {
        this.pageContainerDataResponses = MoreObjects.firstNonNull(pageContainerDataResponses, new ArrayList<PageContainerDataResponse>());
    }

    public List<EngineValue> getTags() {
        return tags;
    }

    public void setTags(List<EngineValue> tags) {
        this.tags = MoreObjects.firstNonNull(tags, new ArrayList<EngineValue>());
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = MoreObjects.firstNonNull(attributes, new HashMap<String, String>());
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
