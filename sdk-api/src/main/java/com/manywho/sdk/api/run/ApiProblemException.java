package com.manywho.sdk.api.run;

import com.google.common.collect.HashMultimap;

public class ApiProblemException extends RuntimeException {
    private String uri;
    private int statusCode;
    private String responseBody;
    private HashMultimap<String, String> responseHeaders;
    private String message;

    public ApiProblemException(String uri, int statusCode, String responseBody, HashMultimap<String, String> responseHeaders, String message) {
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

    public ApiProblemException(int statusCode, String message) {
        this(null, statusCode, message);
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

    public HashMultimap<String, String> getResponseHeaders() {
        return responseHeaders;
    }

    @Override
    public String getMessage() {
        return message;
    }

    private HashMultimap<String, String> stripSecureHeaders(HashMultimap<String, String> headers) {
        if (headers != null && !headers.isEmpty()) {
            for (String secureHeader : new String[]{"Authorization", "X-Forwarded-For"}) {
                if (headers.containsKey(secureHeader)) {
                    headers.removeAll(secureHeader);
                }
            }
        }

        return headers;
    }
}
