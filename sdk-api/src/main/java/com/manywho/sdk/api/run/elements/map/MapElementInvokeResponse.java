package com.manywho.sdk.api.run.elements.map;

import com.manywho.sdk.api.run.elements.ui.PageResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.List;

public class MapElementInvokeResponse {
    private String mapElementId;
    private String developerName;
    private PageResponse pageResponse;
    private List<OutcomeResponse> outcomeResponses;
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

    public List<OutcomeResponse> getOutcomeResponses() {
        return outcomeResponses;
    }

    public boolean hasOutcomeResponses() {
        return CollectionUtils.isNotEmpty(outcomeResponses);
    }

    public void setOutcomeResponses(List<OutcomeResponse> outcomeResponses) {
        this.outcomeResponses = outcomeResponses;
    }

    public HashMap<String, String> getRootFaults() {
        return rootFaults;
    }

    public boolean hasRootFaults() {
        return MapUtils.isNotEmpty(rootFaults);
    }

    public void setRootFaults(HashMap<String, String> rootFaults) {
        this.rootFaults = rootFaults;
    }
}
