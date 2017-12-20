package com.manywho.sdk.api.run.elements.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.elements.map.OutcomeResponse;
import com.manywho.sdk.api.run.elements.ui.PageResponse;

import java.util.List;
import java.util.UUID;

public class UiServiceResponse extends ServiceResponse {
    private PageResponse pageResponse;
    private List<OutcomeResponse> outcomeResponses;
    @JsonProperty("isComplete")
    private boolean isComplete;

    public UiServiceResponse() {
    }

    public UiServiceResponse(InvokeType invokeType, List<EngineValue> outputs, String token, String waitMessage) {
        super(invokeType, outputs, token, waitMessage);
    }

    public UiServiceResponse(UUID tenant, InvokeType invokeType, List<EngineValue> outputs, String token, String waitMessage) {
        super(tenant, invokeType, outputs, token, waitMessage);
    }

    public UiServiceResponse(UUID tenant, InvokeType invokeType, String token, PageResponse pageResponse) {
        super(tenant, invokeType, token);
        this.pageResponse = pageResponse;
    }

    public UiServiceResponse(InvokeType invokeType, List<EngineValue> outputs, String token) {
        super(invokeType, outputs, token);
    }

    public UiServiceResponse(InvokeType invokeType, EngineValue output, String token, String waitMessage) {
        super(invokeType, output, token, waitMessage);
    }

    public UiServiceResponse(InvokeType invokeType, EngineValue output, String token) {
        super(invokeType, output, token);
    }

    public UiServiceResponse(InvokeType invokeType, String token, String waitMessage) {
        super(invokeType, token, waitMessage);
    }

    public UiServiceResponse(InvokeType invokeType, String token) {
        super(invokeType, token);
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

    public void setOutcomeResponses(List<OutcomeResponse> outcomeResponses) {
        this.outcomeResponses = outcomeResponses;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}