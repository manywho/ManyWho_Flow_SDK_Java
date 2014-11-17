package com.manywho.sdk.entities;

public class ObjectDataResponse implements ResponseInterface {
    private Culture culture;
    private ObjectCollection objectData;
    private boolean hasMoreResults;

    public ObjectDataResponse() {
    }

    public ObjectDataResponse(Culture culture, ObjectCollection objectData, boolean hasMoreResults) {
        this.culture = culture;
        this.objectData = objectData;
        this.hasMoreResults = hasMoreResults;
    }

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public ObjectCollection getObjectData() {
        return objectData;
    }

    public void setObjectData(ObjectCollection objectData) {
        this.objectData = objectData;
    }

    public boolean isHasMoreResults() {
        return hasMoreResults;
    }

    public void setHasMoreResults(boolean hasMoreResults) {
        this.hasMoreResults = hasMoreResults;
    }
}
