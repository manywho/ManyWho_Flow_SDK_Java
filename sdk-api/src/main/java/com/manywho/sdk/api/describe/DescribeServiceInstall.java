package com.manywho.sdk.api.describe;

import com.manywho.sdk.api.draw.elements.type.TypeElement;

import java.util.List;

public class DescribeServiceInstall {
    private List<TypeElement> typeElements;

    public DescribeServiceInstall() {
    }

    public DescribeServiceInstall(List<TypeElement> typeElements) {
        this.typeElements = typeElements;
    }

    public List<TypeElement> getTypeElements() {
        return typeElements;
    }

    public void setTypeElements(List<TypeElement> typeElements) {
        this.typeElements = typeElements;
    }
}
