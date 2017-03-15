package com.manywho.sdk.services.types;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.api.draw.elements.type.TypeElement;

import java.util.List;

public class DummyTypeProvider implements TypeProvider {
    @Override
    public boolean doesTypeExist(String name) {
        return false;
    }

    @Override
    public List<TypeElement> describeTypes(DescribeServiceRequest request) {
        return Lists.newArrayList();
    }
}
