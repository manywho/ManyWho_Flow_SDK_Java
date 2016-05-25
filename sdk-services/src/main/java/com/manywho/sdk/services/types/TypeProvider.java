package com.manywho.sdk.services.types;

import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.api.draw.elements.type.TypeElement;

import java.util.List;

public interface TypeProvider {
    boolean doesTypeExist(String name);
    List<TypeElement> describeTypes(DescribeServiceRequest request);
}
