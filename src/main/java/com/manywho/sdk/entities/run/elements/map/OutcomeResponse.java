package com.manywho.sdk.entities.run.elements.map;

public class OutcomeResponse extends OutcomeAvailable {
    private String pageActionBindingType;
    private String pageActionType;
    private boolean isBulkAction;
    private String pageObjectBindingId;
    private boolean isOut;

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
        return isBulkAction;
    }

    public void setBulkAction(boolean isBulkAction) {
        this.isBulkAction = isBulkAction;
    }

    public String getPageObjectBindingId() {
        return pageObjectBindingId;
    }

    public void setPageObjectBindingId(String pageObjectBindingId) {
        this.pageObjectBindingId = pageObjectBindingId;
    }

    public boolean isOut() {
        return isOut;
    }

    public void setOut(boolean isOut) {
        this.isOut = isOut;
    }
}
