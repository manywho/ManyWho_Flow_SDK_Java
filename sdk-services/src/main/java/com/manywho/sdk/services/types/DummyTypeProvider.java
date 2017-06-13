package com.manywho.sdk.services.types;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.describe.DescribeInstallRequest;
import com.manywho.sdk.api.draw.elements.type.TypeElement;
import com.manywho.sdk.services.configuration.Configuration;

import java.util.List;

public class DummyTypeProvider implements TypeProvider {
    @Override
    public boolean doesTypeExist(Configuration configuration, String name) {
        return false;
    }

    @Override
    public List<TypeElement> describeTypes(Configuration configuration, DescribeInstallRequest request) {
        return Lists.newArrayList();
    }
}
