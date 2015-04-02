package com.manywho.sdk.services.providers;

import javax.ws.rs.core.Response;

public class CustomReasonPhraseExceptionStatusType implements Response.StatusType {

    private final Response.Status.Family family;
    private final int statusCode;
    private final String reasonPhrase;

    public CustomReasonPhraseExceptionStatusType(Response.Status httpStatus, String message) {
        this.family = httpStatus.getFamily();
        this.statusCode = httpStatus.getStatusCode();
        this.reasonPhrase = httpStatus.getReasonPhrase() + ": " + message;
    }

    @Override
    public int getStatusCode() {
        return statusCode;
    }

    @Override
    public Response.Status.Family getFamily() {
        return family;
    }

    @Override
    public String getReasonPhrase() {
        return reasonPhrase;
    }
}