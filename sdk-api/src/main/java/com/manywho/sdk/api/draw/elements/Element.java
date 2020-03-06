package com.manywho.sdk.api.draw.elements;

public class Element implements Comparable<Element> {
    protected String elementType = "TYPE";
    protected String developerName;
    protected String developerSummary;

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getDeveloperSummary() {
        return developerSummary;
    }

    public void setDeveloperSummary(String developerSummary) {
        this.developerSummary = developerSummary;
    }

    @Override
    public int compareTo(Element element) {
        return developerName.compareTo(element.getDeveloperName());
    }
}
