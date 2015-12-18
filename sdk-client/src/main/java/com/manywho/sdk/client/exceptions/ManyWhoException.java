package com.manywho.sdk.client.exceptions;

import org.apache.http.HttpResponse;

public class ManyWhoException extends RuntimeException {
    private HttpResponse response;

    public ManyWhoException(HttpResponse response) {
        super("There was a problem with the call to ManyWho: " + response.getStatusLine().getReasonPhrase());

        this.response = response;
    }

    public HttpResponse getResponse() {
        return response;
    }
}
