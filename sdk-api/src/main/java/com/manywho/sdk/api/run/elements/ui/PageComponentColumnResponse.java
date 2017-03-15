package com.manywho.sdk.api.run.elements.ui;

import java.util.UUID;

public class PageComponentColumnResponse {
    private String developerName;
    private UUID typeElementPropertyId;
    private String label;
    private boolean isDisplayValue;
    private int order;

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public UUID getTypeElementPropertyId() {
        return typeElementPropertyId;
    }

    public void setTypeElementPropertyId(UUID typeElementPropertyId) {
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
