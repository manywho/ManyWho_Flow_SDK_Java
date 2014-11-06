package com.manywho.sdk.entities;

import java.lang.Object;

public class OutcomeAvailable implements Comparable {
    private String id;
    private String developerName;
    private String label;
    private int order;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int compareTo(Object o) {
        int result = 0;

        if (o instanceof OutcomeAvailable)
        {
            OutcomeAvailable outcome = (OutcomeAvailable) o;

            if (outcome.getOrder() > this.getOrder()) {
                result = -1;
            } else if (outcome.getOrder() < this.getOrder()) {
                result = 1;
            }
        }

        return result;
    }
}
