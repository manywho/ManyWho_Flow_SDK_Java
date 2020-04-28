package com.manywho.sdk.api.describe;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.draw.elements.type.TypeElement;

import java.util.ArrayList;
import java.util.List;

public class DescribeInstallResponse {
    private List<DescribeServiceActionResponse> actions = Lists.newArrayList();
    private List<TypeElement> types;

    public List<DescribeServiceActionResponse> getActions() {
        return actions;
    }

    public void setActions(List<DescribeServiceActionResponse> actions) {
        this.actions = MoreObjects.firstNonNull(actions, new ArrayList<DescribeServiceActionResponse>());
    }

    public List<TypeElement> getTypes() {
        return types;
    }

    public void setTypes(List<TypeElement> types) {
        this.types = types;
    }
}
