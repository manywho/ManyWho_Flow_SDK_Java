package com.manywho.sdk.api.run.elements.type;

import java.util.List;

public class ObjectDataTypeProperty {
    private String developerName;
    private List<ObjectDataType> list;

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
        this.list = list;
    }
}
