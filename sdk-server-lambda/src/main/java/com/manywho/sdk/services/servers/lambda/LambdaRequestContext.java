package com.manywho.sdk.services.servers.lambda;

import org.apache.commons.fileupload.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class LambdaRequestContext implements RequestContext {
    private final static Logger LOGGER = LoggerFactory.getLogger(LambdaRequestContext.class);

    private final InputStream body;
    private final Map<String, String> headers;

    public LambdaRequestContext(InputStream body, Map<String, String> headers) {
        this.body = body;
        this.headers = headers;
    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public String getContentType() {
        return headers.get("Content-Type");
    }

    @Override
    public int getContentLength() {
        try {
            return body.available();
        } catch (IOException e) {
            LOGGER.error("Unable to find the content length of the request", e);

            throw new RuntimeException("Unable to find the content length of the request", e);
        }
    }

    @Override
    public InputStream getInputStream() {
        return body;
    }
}
