package com.manywho.sdk.api.run.elements.map;

import com.manywho.sdk.api.run.elements.ui.PageRequest;

public class MapElementInvokeRequest {
    private String selectedOutcomeId;
    private PageRequest pageRequest;

    public MapElementInvokeRequest() {
    }

    public MapElementInvokeRequest(String selectedOutcomeId) {
        this.selectedOutcomeId = selectedOutcomeId;
    }

    public MapElementInvokeRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }

    public MapElementInvokeRequest(String selectedOutcomeId, PageRequest pageRequest) {
        this.selectedOutcomeId = selectedOutcomeId;
        this.pageRequest = pageRequest;
    }

    public String getSelectedOutcomeId() {
        return selectedOutcomeId;
    }

    public void setSelectedOutcomeId(String selectedOutcomeId) {
        this.selectedOutcomeId = selectedOutcomeId;
    }

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }
}
