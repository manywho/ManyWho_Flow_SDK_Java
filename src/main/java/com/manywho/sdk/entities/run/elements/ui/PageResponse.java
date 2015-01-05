package com.manywho.sdk.entities.run.elements.ui;

import com.manywho.sdk.entities.run.EngineValueCollection;

import java.util.HashMap;

public class PageResponse {
    private String label;
    private PageContainerResponseCollection pageContainerResponses;
    private PageComponentResponseCollection pageComponentResponses;
    private PageComponentDataResponseCollection pageComponentDataResponses;
    private PageContainerDataResponseCollection pageContainerDataResponses;
    private EngineValueCollection tags;
    private HashMap<String, String> attributes;
    private int order;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public PageContainerResponseCollection getPageContainerResponses() {
        return pageContainerResponses;
    }

    public void setPageContainerResponses(PageContainerResponseCollection pageContainerResponses) {
        this.pageContainerResponses = pageContainerResponses;
    }

    public PageComponentResponseCollection getPageComponentResponses() {
        return pageComponentResponses;
    }

    public void setPageComponentResponses(PageComponentResponseCollection pageComponentResponses) {
        this.pageComponentResponses = pageComponentResponses;
    }

    public PageComponentDataResponseCollection getPageComponentDataResponses() {
        return pageComponentDataResponses;
    }

    public void setPageComponentDataResponses(PageComponentDataResponseCollection pageComponentDataResponses) {
        this.pageComponentDataResponses = pageComponentDataResponses;
    }

    public PageContainerDataResponseCollection getPageContainerDataResponses() {
        return pageContainerDataResponses;
    }

    public void setPageContainerDataResponses(PageContainerDataResponseCollection pageContainerDataResponses) {
        this.pageContainerDataResponses = pageContainerDataResponses;
    }

    public EngineValueCollection getTags() {
        return tags;
    }

    public void setTags(EngineValueCollection tags) {
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
