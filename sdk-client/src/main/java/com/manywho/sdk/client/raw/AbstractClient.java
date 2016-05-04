package com.manywho.sdk.client.raw;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.manywho.sdk.client.mappers.ResponseMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import static com.manywho.sdk.services.providers.ObjectMapperProvider.getObjectMapper;

abstract class AbstractClient {
    protected URI baseUri = URI.create("https://flow.manywho.com/api/run/1");

    protected HttpClient httpClient;

    public AbstractClient() {
        this.httpClient = HttpClients.createDefault();
    }

    public AbstractClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = URI.create(baseUri);
    }

    public void setBaseUri(URI baseUri) {
        this.baseUri = baseUri;
    }

    protected HttpEntity createEntity(Object object) {
        try {
            return new ByteArrayEntity(getObjectMapper().writeValueAsBytes(object));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Unable to create the request entity");
        }
    }

    protected <T> T executeWithResponse(HttpRequestBase request, Class<T> tClass) {
        try {
            return httpClient.execute(request, response -> {
                return ResponseMapper.parseResponse(response, tClass);
            });
        } catch (IOException e) {
            throw new RuntimeException("Unable to parse the response as JSON", e);
        }
    }

    protected <T> List<T> executeWithListResponse(HttpRequestBase request, Class<T> tClass) {
        try {
            return httpClient.execute(request, response -> {
                return ResponseMapper.parseListResponse(response, tClass);
            });
        } catch (IOException e) {
            throw new RuntimeException("Unable to parse the response as JSON", e);
        }
    }
}
