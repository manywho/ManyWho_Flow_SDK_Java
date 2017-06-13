package com.manywho.sdk.services.types;

import com.manywho.sdk.api.describe.DescribeInstallRequest;
import com.manywho.sdk.api.draw.elements.type.TypeElement;
import com.manywho.sdk.services.configuration.Configuration;

import java.util.List;

public interface TypeProvider<C extends Configuration> {
    boolean doesTypeExist(C configuration, String name);
    List<TypeElement> describeTypes(C configuration, DescribeInstallRequest request);
}
