package com.manywho.sdk.client;

import com.manywho.sdk.client.mappers.ResponseMapper;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;
import java.util.List;

abstract class AbstractClient {
    protected URI baseUri = URI.create("https://flow.manywho.com/api/run/1");

    protected HttpClient httpClient;

    public AbstractClient() {
        this.httpClient = HttpClients.createDefault();
    }

    public AbstractClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public AbstractClient(String baseUri) {
        this();
        this.baseUri = URI.create(baseUri);
    }

    protected <T> T executeWithResponse(HttpRequestBase request, Class<T> tClass) throws IOException {
        return httpClient.execute(request, response -> {
            return ResponseMapper.parseResponse(response, tClass);
        });
    }

    protected <T> List<T> executeWithListResponse(HttpRequestBase request, Class<T> tClass) throws IOException {
        return httpClient.execute(request, response -> {
            return ResponseMapper.parseListResponse(response, tClass);
        });
    }
}
