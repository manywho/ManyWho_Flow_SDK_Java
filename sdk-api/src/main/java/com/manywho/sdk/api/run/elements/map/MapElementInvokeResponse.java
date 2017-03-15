package com.manywho.sdk.api.run.elements.map;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.manywho.sdk.api.run.elements.ui.PageResponse;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MapElementInvokeResponse {
    private UUID mapElementId;
    private String developerName;
    private PageResponse pageResponse;
    private List<OutcomeResponse> outcomeResponses = Lists.newArrayList();
    private Map<String, String> rootFaults = Maps.newHashMap();

    public UUID getMapElementId() {
        return mapElementId;
    }

    public void setMapElementId(UUID mapElementId) {
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
        return !outcomeResponses.isEmpty();
    }

    public void setOutcomeResponses(List<OutcomeResponse> outcomeResponses) {
        this.outcomeResponses = MoreObjects.firstNonNull(outcomeResponses, Lists.newArrayList());
    }

    public Map<String, String> getRootFaults() {
        return rootFaults;
    }

    public boolean hasRootFaults() {
        return !rootFaults.isEmpty();
    }

    public void setRootFaults(Map<String, String> rootFaults) {
        this.rootFaults = MoreObjects.firstNonNull(rootFaults, Maps.newHashMap());
    }
}
