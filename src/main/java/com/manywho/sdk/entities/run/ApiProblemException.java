package com.manywho.sdk.entities.run;

import javax.ws.rs.core.MultivaluedMap;

public class ApiProblemException extends Exception {
    private String uri;
    private int statusCode;
    private String responseBody;
    private MultivaluedMap<String, String> responseHeaders;
    private String message;

    public ApiProblemException(String uri, int statusCode, String responseBody, MultivaluedMap<String, String> responseHeaders, String message) {
        this.uri = uri;
        this.statusCode = statusCode;
        this.responseBody = responseBody;
        this.responseHeaders = responseHeaders;
        this.message = message;
    }

    public String getUri() {
        return uri;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public MultivaluedMap<String, String> getResponseHeaders() {
        return responseHeaders;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
