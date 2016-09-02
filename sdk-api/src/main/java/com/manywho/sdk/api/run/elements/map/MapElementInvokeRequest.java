package com.manywho.sdk.api.run.elements.map;

import com.manywho.sdk.api.run.elements.ui.PageRequest;

import java.util.UUID;

public class MapElementInvokeRequest {
    private UUID selectedOutcomeId;
    private PageRequest pageRequest;

    public MapElementInvokeRequest() {
    }

    public MapElementInvokeRequest(UUID selectedOutcomeId) {
        this.selectedOutcomeId = selectedOutcomeId;
    }

    public MapElementInvokeRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }

    public MapElementInvokeRequest(UUID selectedOutcomeId, PageRequest pageRequest) {
        this.selectedOutcomeId = selectedOutcomeId;
        this.pageRequest = pageRequest;
    }

    public UUID getSelectedOutcomeId() {
        return selectedOutcomeId;
    }

    public void setSelectedOutcomeId(UUID selectedOutcomeId) {
        this.selectedOutcomeId = selectedOutcomeId;
    }

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }
}
