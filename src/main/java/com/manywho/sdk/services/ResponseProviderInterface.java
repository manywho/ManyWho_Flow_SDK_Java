package com.manywho.sdk.services;

import com.manywho.sdk.entities.ResponseInterface;

public interface ResponseProviderInterface {
    public ResponseInterface createResponse() throws Exception;
}
