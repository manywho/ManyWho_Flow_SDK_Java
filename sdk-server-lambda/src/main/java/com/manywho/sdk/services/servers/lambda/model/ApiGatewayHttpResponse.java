package com.manywho.sdk.services.servers.lambda.model;

import java.util.Map;

public class ApiGatewayHttpResponse {
    private String body;
    private int statusCode;
    private String isBase64Encoded;
    private Map<String, String> headers;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getIsBase64Encoded() {
        return isBase64Encoded;
    }

    public void setIsBase64Encoded(String isBase64Encoded) {
        this.isBase64Encoded = isBase64Encoded;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
