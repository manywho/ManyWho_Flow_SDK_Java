package com.manywho.sdk.entities.run;

import com.manywho.sdk.enums.ProblemKind;

import javax.ws.rs.core.MultivaluedMap;

public class ApiProblem {
    private ProblemKind kind;
    private String uri;
    private int statusCode;
    private String responseBody;
    private MultivaluedMap<String, String> responseHeaders;
    private String message;

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

    public MultivaluedMap<String, String> getResponseHeaders() {
        return responseHeaders;
    }

    public String getMessage() {
        return message;
    }
}
