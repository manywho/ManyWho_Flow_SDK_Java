package com.manywho.sdk.entities.run;

import com.manywho.sdk.enums.EndpointType;
import com.manywho.sdk.enums.InvokeType;

import javax.ws.rs.core.MultivaluedHashMap;

public class ServiceProblemException extends ApiProblemException {
    private InvokeType invokeType;
    private String action;

    public ServiceProblemException(String uri, int statusCode, String responseBody, MultivaluedHashMap<String, String> responseHeaders, String message, InvokeType invokeType, String action) {
        super(uri, statusCode, responseBody, responseHeaders, message);
        this.invokeType = invokeType;
        this.action = action;
    }

    public ServiceProblemException(String uri, int statusCode, String message, String action) {
        this(uri, statusCode, null, null, message, null, action);
    }

    public ServiceProblemException(String uri, int statusCode, String message, EndpointType endpointType) {
        this(uri, statusCode, message, endpointType.toString());
    }

    public ServiceProblemException(String uri, int statusCode, String message) {
        this(uri, statusCode, null, null, message, null, null);
    }

    public ServiceProblemException(String uri, int statusCode, String responseBody, String message, String action) {
        this(uri, statusCode, responseBody, null, message, null, action);
    }

    public ServiceProblemException(String uri, int statusCode, String responseBody, String message, EndpointType endpointType) {
        this(uri, statusCode, responseBody, null, message, null, endpointType.toString());
    }

    public InvokeType getInvokeType() {
        return invokeType;
    }

    public String getAction() {
        return action;
    }
}
