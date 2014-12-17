package com.manywho.sdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.entities.run.EngineInitializationRequest;
import com.manywho.sdk.entities.run.EngineInitializationResponse;
import com.manywho.sdk.entities.run.Request;
import com.manywho.sdk.entities.run.elements.config.ListenerServiceResponse;
import com.manywho.sdk.entities.run.Response;
import com.manywho.sdk.entities.run.elements.config.ServiceResponse;
import com.manywho.sdk.entities.security.AuthenticatedWho;
import com.manywho.sdk.enums.InvokeType;
import com.manywho.sdk.utils.AuthorizationUtils;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequestWithBody;

import java.io.InputStream;

// @todo Add notifier stuff to these methods
public class RunService {

    public EngineInitializationResponse initializeFlow(AuthenticatedWho authenticatedWho, String tenantId, EngineInitializationRequest engineInitializationRequest) throws Exception {
        return this.execute(authenticatedWho, tenantId, "https://flow.manywho.com/api/run/1", engineInitializationRequest, EngineInitializationResponse.class);
    }

    public InvokeType sendEvent(AuthenticatedWho authenticatedWho, String tenantId, String callbackUri, ListenerServiceResponse listenerServiceResponse) throws Exception {
        return this.executeCallback(authenticatedWho, tenantId, callbackUri, listenerServiceResponse);
    }

    public InvokeType sendResponse(AuthenticatedWho authenticatedWho, String tenantId, String callbackUri, ServiceResponse serviceResponse) throws Exception {
        return this.executeCallback(authenticatedWho, tenantId, callbackUri, serviceResponse);
    }

    protected HttpRequestWithBody createHttpClient(AuthenticatedWho authenticatedWho, String tenantId, String callbackUri) {
        return Unirest.post(callbackUri)
                .header("Authorization", AuthorizationUtils.serialize(authenticatedWho))
                .header("ManyWhoTenant", tenantId)
                .header("Content-Type", "application/json");
    }

    protected <T> T execute(AuthenticatedWho authenticatedWho, String tenantId, String callbackUri, Request request, Class<T> responseClass) throws Exception {
        InputStream body = this.createHttpClient(authenticatedWho, tenantId, callbackUri)
                .body(new ObjectMapper().writeValueAsString(request))
                .asJson()
                .getRawBody();

        return new ObjectMapper().readValue(body, responseClass);
    }

    protected InvokeType executeCallback(AuthenticatedWho authenticatedWho, String tenantId, String callbackUri, Response response) throws Exception {
        String responseBody = this.createHttpClient(authenticatedWho, tenantId, callbackUri)
                .body(new ObjectMapper().writeValueAsString(response))
                .asString()
                .getBody();

        return InvokeType.valueOf(responseBody);
    }
}
