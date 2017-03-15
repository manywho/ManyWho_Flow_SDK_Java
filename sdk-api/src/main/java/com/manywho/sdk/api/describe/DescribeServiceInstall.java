package com.manywho.sdk.api.describe;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.draw.elements.type.TypeElement;

import java.util.List;

public class DescribeServiceInstall {
    private List<TypeElement> typeElements = Lists.newArrayList();

    public DescribeServiceInstall() {
    }

    public DescribeServiceInstall(List<TypeElement> typeElements) {
        this.typeElements = MoreObjects.firstNonNull(typeElements, Lists.newArrayList());
    }

    public List<TypeElement> getTypeElements() {
        return typeElements;
    }

    public void setTypeElements(List<TypeElement> typeElements) {
        this.typeElements = MoreObjects.firstNonNull(typeElements, Lists.newArrayList());
    }
}
