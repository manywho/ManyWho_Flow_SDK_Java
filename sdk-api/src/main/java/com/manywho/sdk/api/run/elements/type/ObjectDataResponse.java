package com.manywho.sdk.api.run.elements.type;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.translate.Culture;

import java.util.ArrayList;
import java.util.List;

public class ObjectDataResponse {
    private Culture culture;
    private List<MObject> objectData = Lists.newArrayList();
    private boolean hasMoreResults;
    private String offsetToken;

    public ObjectDataResponse() {
    }

    public ObjectDataResponse(MObject object) {
        this.objectData = Lists.newArrayList(object);
    }

    public ObjectDataResponse(List<MObject> objectData) {
        this(null, objectData, false);
    }

    public ObjectDataResponse(List<MObject> objectData, boolean hasMoreResults) {
        this(null, objectData, hasMoreResults);
    }

    public ObjectDataResponse(Culture culture, List<MObject> objectData, boolean hasMoreResults) {
        this.culture = culture;
        this.objectData = MoreObjects.firstNonNull(objectData, new ArrayList<MObject>());
        this.hasMoreResults = hasMoreResults;
    }

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public List<MObject> getObjectData() {
        return objectData;
    }

    public void setObjectData(List<MObject> objectData) {
        this.objectData = MoreObjects.firstNonNull(objectData, new ArrayList<MObject>());
    }

    public boolean isHasMoreResults() {
        return hasMoreResults;
    }

    public void setHasMoreResults(boolean hasMoreResults) {
        this.hasMoreResults = hasMoreResults;
    }

    public String getOffsetToken() {
        return offsetToken;
    }

    public void setOffsetToken(String offsetToken) {
        this.offsetToken = offsetToken;
    }
}
