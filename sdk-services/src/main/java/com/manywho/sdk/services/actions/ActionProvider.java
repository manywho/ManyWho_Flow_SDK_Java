package com.manywho.sdk.services.actions;

import com.manywho.sdk.api.describe.DescribeServiceActionResponse;
import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.services.configuration.Configuration;

import java.util.List;

public interface ActionProvider<C extends Configuration> {
    List<DescribeServiceActionResponse> describeActions(C configuration, DescribeServiceRequest request);
}
