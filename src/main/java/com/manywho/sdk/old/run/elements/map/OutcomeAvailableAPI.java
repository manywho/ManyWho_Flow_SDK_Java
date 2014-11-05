package com.manywho.sdk.old.run.elements.map;

public class OutcomeAvailableAPI implements Comparable {
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
        if (o instanceof OutcomeAvailableAPI) {
            if (((OutcomeAvailableAPI) o).order > this.order) {
                return -1;
            } else {
                return 1;
            }
        }

        return 0;
    }
}
