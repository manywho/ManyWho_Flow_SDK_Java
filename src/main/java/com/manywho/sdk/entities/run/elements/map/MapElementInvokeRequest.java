package com.manywho.sdk.entities.run.elements.map;

import com.manywho.sdk.entities.run.elements.ui.PageRequest;

public class MapElementInvokeRequest {
    private String selectedOutcomeId;
    private PageRequest pageRequest;

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
