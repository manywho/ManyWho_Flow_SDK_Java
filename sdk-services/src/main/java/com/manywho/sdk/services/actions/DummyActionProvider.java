package com.manywho.sdk.services.actions;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.describe.DescribeServiceActionResponse;
import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.services.configuration.Configuration;

import java.util.List;

public class DummyActionProvider implements ActionProvider {
    @Override
    public boolean doesActionExist(Configuration configuration, String uriPart) {
        return false;
    }

    @Override
    public List<DescribeServiceActionResponse> describeActions(Configuration configuration, DescribeServiceRequest request) {
        return Lists.newArrayList();
    }
}
