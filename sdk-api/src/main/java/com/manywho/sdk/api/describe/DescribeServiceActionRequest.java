package com.manywho.sdk.api.describe;

import java.util.List;

public class DescribeServiceActionRequest {
    protected String uriPart;
    protected List<DescribeValue> serviceInputs;
    protected List<DescribeValue> serviceOutputs;

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
        this.serviceInputs = serviceInputs;
    }

    public List<DescribeValue> getServiceOutputs() {
        return serviceOutputs;
    }

    public void setServiceOutputs(List<DescribeValue> serviceOutputs) {
        this.serviceOutputs = serviceOutputs;
    }
}
