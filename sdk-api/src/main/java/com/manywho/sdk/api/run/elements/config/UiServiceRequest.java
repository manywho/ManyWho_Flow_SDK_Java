package com.manywho.sdk.api.run.elements.config;

import com.manywho.sdk.api.run.elements.ui.PageRequest;

import java.util.UUID;

public class UiServiceRequest extends ServiceRequest {
    private UUID currentMapElementId;
    private UUID selectedOutcomeId;
    private PageRequest pageRequest;

    public UUID getCurrentMapElementId() {
        return currentMapElementId;
    }

    public void setCurrentMapElementId(UUID currentMapElementId) {
        this.currentMapElementId = currentMapElementId;
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