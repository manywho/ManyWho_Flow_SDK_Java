package com.manywho.sdk.entities.run.elements.map;

import com.manywho.sdk.entities.run.elements.ui.PageResponse;
import org.apache.commons.collections4.CollectionUtils;

import java.util.HashMap;

public class MapElementInvokeResponse {
    private String mapElementId;
    private String developerName;
    private PageResponse pageResponse;
    private OutcomeResponseCollection outcomeResponses;
    private HashMap<String, String> rootFaults;

    public String getMapElementId() {
        return mapElementId;
    }

    public void setMapElementId(String mapElementId) {
        this.mapElementId = mapElementId;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public PageResponse getPageResponse() {
        return pageResponse;
    }

    public void setPageResponse(PageResponse pageResponse) {
        this.pageResponse = pageResponse;
    }

    public OutcomeResponseCollection getOutcomeResponses() {
        return outcomeResponses;
    }

    public boolean hasOutcomeResponses() {
        return CollectionUtils.isNotEmpty(outcomeResponses);
    }

    public void setOutcomeResponses(OutcomeResponseCollection outcomeResponses) {
        this.outcomeResponses = outcomeResponses;
    }

    public HashMap<String, String> getRootFaults() {
        return rootFaults;
    }

    public void setRootFaults(HashMap<String, String> rootFaults) {
        this.rootFaults = rootFaults;
    }
}
