package com.manywho.services.example.actions;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.describe.DescribeServiceActionResponse;
import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.api.describe.DescribeValue;
import com.manywho.sdk.services.actions.ActionProvider;
import com.manywho.sdk.services.configuration.Configuration;

import java.util.List;

public class RawActionProvider implements ActionProvider{
    @Override
    public boolean doesActionExist(Configuration configuration, String name) {
        return false;
    }

    @Override
    public List<DescribeServiceActionResponse> describeActions(Configuration configuration, DescribeServiceRequest request) {
        List<DescribeServiceActionResponse> customActions = Lists.newArrayList();
        customActions.add(createAction());

        return customActions;
    }

    private DescribeServiceActionResponse createAction() {
        List<DescribeValue> serviceInputs = Lists.newArrayList();
        List<DescribeValue> serviceOutputs = Lists.newArrayList();
        serviceInputs.add(new DescribeValue("Input 1", ContentType.String));
        serviceOutputs.add(new DescribeValue("Output 1", ContentType.String));

        return new DescribeServiceActionResponse(
                "Custom Action Name",
                "Custom Action Summary",
                "custom-action",
                serviceInputs,
                serviceOutputs
        );
    }
}
