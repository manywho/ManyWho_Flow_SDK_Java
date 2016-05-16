package com.manywho.sdk.api.run.elements.ui;

public class PageComponentColumnResponse {
    private String developerName;
    private String typeElementPropertyId;
    private String label;
    private boolean isDisplayValue;
    private int order;

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getTypeElementPropertyId() {
        return typeElementPropertyId;
    }

    public void setTypeElementPropertyId(String typeElementPropertyId) {
        this.typeElementPropertyId = typeElementPropertyId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isDisplayValue() {
        return isDisplayValue;
    }

    public void setDisplayValue(boolean isDisplayValue) {
        this.isDisplayValue = isDisplayValue;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
