package com.manywho.sdk.entities.describe;

import com.manywho.sdk.entities.draw.elements.type.TypeElementCollection;

// @todo Rename this class
public class DescribeServiceInstall {
    private TypeElementCollection typeElements;

    public DescribeServiceInstall() {
    }

    public DescribeServiceInstall(TypeElementCollection typeElements) {
        this.typeElements = typeElements;
    }

    public TypeElementCollection getTypeElements() {
        return typeElements;
    }

    public void setTypeElements(TypeElementCollection typeElements) {
        this.typeElements = typeElements;
    }
}
