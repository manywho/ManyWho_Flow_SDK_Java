package com.manywho.sdk.api.describe;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class DescribeServiceActionRequest {
    protected String uriPart;
    protected List<DescribeValue> serviceInputs = Lists.newArrayList();
    protected List<DescribeValue> serviceOutputs = Lists.newArrayList();

    public String getUriPart() {
        return uriPart;
    }

    public void setUriPart(String uriPart) {
        this.uriPart = uriPart;
    }

    public List<DescribeValue> getServiceInputs() {
        return serviceInputs;
    }

    public void setServiceInputs(List<DescribeValue> serviceInputs) {
        this.serviceInputs = MoreObjects.firstNonNull(serviceInputs, new ArrayList<DescribeValue>());
    }

    public List<DescribeValue> getServiceOutputs() {
        return serviceOutputs;
    }

    public void setServiceOutputs(List<DescribeValue> serviceOutputs) {
        this.serviceOutputs = MoreObjects.firstNonNull(serviceOutputs, new ArrayList<DescribeValue>());
    }
}
