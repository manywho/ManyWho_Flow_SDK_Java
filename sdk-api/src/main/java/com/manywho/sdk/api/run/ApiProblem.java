package com.manywho.sdk.api.run;

import com.google.common.collect.HashMultimap;

public class ApiProblem {
    private ProblemKind kind;
    private String uri;
    private int statusCode;
    private String responseBody;
    private HashMultimap<String, String> responseHeaders;
    private String message;

    public ApiProblem() {
    }

    public ApiProblem(ProblemKind kind, String uri, int statusCode, String responseBody, HashMultimap<String, String> responseHeaders, String message) {
        this.kind = kind;
        this.uri = uri;
        this.statusCode = statusCode;
        this.responseBody = responseBody;
        this.responseHeaders = responseHeaders;
        this.message = message;
    }

    public ApiProblem(String uri, int statusCode, String message) {
        this.kind = ProblemKind.Api;
        this.uri = uri;
        this.statusCode = statusCode;
        this.message = message;
    }

    public ApiProblem(ProblemKind kind, String uri, int statusCode, String message) {
        this.kind = kind;
        this.uri = uri;
        this.statusCode = statusCode;
        this.message = message;
    }

    public ApiProblem(ApiProblemException apiProblemException) {
        this.kind = ProblemKind.Api;
        this.uri = apiProblemException.getUri();
        this.statusCode = apiProblemException.getStatusCode();
        this.responseBody = apiProblemException.getResponseBody();
        this.responseHeaders = apiProblemException.getResponseHeaders();
        this.message = apiProblemException.getMessage();
    }

    public ApiProblem(ProblemKind problemKind, ApiProblemException apiProblemException) {
        this.kind = problemKind;
        this.uri = apiProblemException.getUri();
        this.statusCode = apiProblemException.getStatusCode();
        this.responseBody = apiProblemException.getResponseBody();
        this.responseHeaders = apiProblemException.getResponseHeaders();
        this.message = apiProblemException.getMessage();
    }

    public ProblemKind getKind() {
        return kind;
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

    public String getMessage() {
        return message;
    }

    public static enum ProblemKind {
        Api("api"),
        Service("service");

        private final String text;

        ProblemKind(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
