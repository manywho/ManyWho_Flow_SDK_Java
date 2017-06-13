package com.manywho.sdk.services.actions;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.describe.DescribeInstallRequest;
import com.manywho.sdk.api.describe.DescribeServiceActionResponse;
import com.manywho.sdk.services.configuration.Configuration;

import java.util.List;

public class DummyActionProvider implements ActionProvider {
    @Override
    public List<DescribeServiceActionResponse> describeActions(Configuration configuration, DescribeInstallRequest request) {
        return Lists.newArrayList();
    }
}
