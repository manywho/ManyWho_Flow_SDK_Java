package com.manywho.sdk.server.lambda.model;

import java.util.Map;

public class HttpRequest {
    private String httpMethod;
    private String body;
    private String path;
    private boolean isBase64Encoded;
    private Map<String, String> headers;

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getBody() {
        return body;
    }

    public String getPath() {
        return path;
    }

    public boolean isBase64Encoded() {
        return isBase64Encoded;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
