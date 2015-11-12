package com.manywho.sdk.entities.run;

import org.apache.commons.collections4.MapUtils;

import javax.ws.rs.core.MultivaluedHashMap;

public class ApiProblemException extends Exception {
    private String uri;
    private int statusCode;
    private String responseBody;
    private MultivaluedHashMap<String, String> responseHeaders;
    private String message;

    public ApiProblemException(String uri, int statusCode, String responseBody, MultivaluedHashMap<String, String> responseHeaders, String message) {
        this.uri = uri;
        this.statusCode = statusCode;
        this.responseBody = responseBody;
        this.message = message;
        this.responseHeaders = stripSecureHeaders(responseHeaders);
    }

    public ApiProblemException(String uri, int statusCode, String responseBody, String message) {
        this(uri, statusCode, responseBody, null, message);
    }

    public ApiProblemException(String uri, int statusCode, String message) {
        this(uri, statusCode, null, message);
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

    public MultivaluedHashMap<String, String> getResponseHeaders() {
        return responseHeaders;
    }

    @Override
    public String getMessage() {
        return message;
    }

    private MultivaluedHashMap<String, String> stripSecureHeaders(MultivaluedHashMap<String, String> headers) {
        if (MapUtils.isNotEmpty(headers)) {
            for (String secureHeader : new String[]{"Authorization", "X-Forwarded-For"}) {
                if (headers.containsKey(secureHeader)) {
                    headers.remove(secureHeader);
                }
            }
        }

        return headers;
    }
}
