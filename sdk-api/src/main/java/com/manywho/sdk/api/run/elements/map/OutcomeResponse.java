package com.manywho.sdk.api.run.elements.map;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class OutcomeResponse extends OutcomeAvailable {
    private String pageActionBindingType;
    private String pageActionType;
    @JsonProperty("isBulkAction")
    private boolean bulkAction;
    private UUID pageObjectBindingId;
    @JsonProperty("isOut")
    private boolean out;

    public String getPageActionBindingType() {
        return pageActionBindingType;
    }

    public void setPageActionBindingType(String pageActionBindingType) {
        this.pageActionBindingType = pageActionBindingType;
    }

    public String getPageActionType() {
        return pageActionType;
    }

    public void setPageActionType(String pageActionType) {
        this.pageActionType = pageActionType;
    }

    public boolean isBulkAction() {
        return bulkAction;
    }

    public void setBulkAction(boolean isBulkAction) {
        this.bulkAction = isBulkAction;
    }

    public UUID getPageObjectBindingId() {
        return pageObjectBindingId;
    }

    public void setPageObjectBindingId(UUID pageObjectBindingId) {
        this.pageObjectBindingId = pageObjectBindingId;
    }

    public boolean isOut() {
        return out;
    }

    public void setOut(boolean isOut) {
        this.out = isOut;
    }
}
