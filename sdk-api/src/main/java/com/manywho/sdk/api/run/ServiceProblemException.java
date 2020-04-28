package com.manywho.sdk.api.run;

import com.google.common.collect.HashMultimap;
import com.manywho.sdk.api.InvokeType;

public class ServiceProblemException extends ApiProblemException {
    private InvokeType invokeType;
    private String action;

    public ServiceProblemException(String uri, int statusCode, String responseBody, HashMultimap<String, String> responseHeaders, String message, InvokeType invokeType, String action) {
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

    public ServiceProblemException(int statusCode, String message) {
        super(statusCode, message);
    }

    public InvokeType getInvokeType() {
        return invokeType;
    }

    public String getAction() {
        return action;
    }

    public enum EndpointType {
        Load("LOAD"),
        Save("SAVE");

        private final String text;

        EndpointType(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
