package com.manywho.sdk.services;

import com.manywho.sdk.entities.responses.ResponseInterface;

public interface ResponseProviderInterface {
    public ResponseInterface createResponse() throws Exception;
}
