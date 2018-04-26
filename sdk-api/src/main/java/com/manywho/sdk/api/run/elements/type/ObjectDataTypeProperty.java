package com.manywho.sdk.api.run.elements.type;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class ObjectDataTypeProperty {
    private String developerName;
    private List<ObjectDataType> list = Lists.newArrayList();

    public ObjectDataTypeProperty() {
    }

    public ObjectDataTypeProperty(String developerName) {
        this.developerName = developerName;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public List<ObjectDataType> getList() {
        return list;
    }

    public void setList(List<ObjectDataType> list) {
        this.list = MoreObjects.firstNonNull(list, new ArrayList<ObjectDataType>());
    }
}
