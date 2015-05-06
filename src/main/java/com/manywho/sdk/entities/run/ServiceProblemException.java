package com.manywho.sdk.entities.run;

import com.manywho.sdk.enums.InvokeType;

import javax.ws.rs.core.MultivaluedMap;

public class ServiceProblemException extends ApiProblemException {
    private InvokeType invokeType;
    private String action;

    public ServiceProblemException(String uri, int statusCode, String responseBody, MultivaluedMap<String, String> responseHeaders, String message, InvokeType invokeType, String action) {
        super(uri, statusCode, responseBody, responseHeaders, message);
        this.invokeType = invokeType;
        this.action = action;
    }

    public InvokeType getInvokeType() {
        return invokeType;
    }

    public String getAction() {
        return action;
    }
}
