package com.manywho.sdk;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.manywho.sdk.services.notifications.Notifier;
import com.manywho.sdk.entities.run.*;
import com.manywho.sdk.entities.run.elements.config.ListenerServiceResponse;
import com.manywho.sdk.entities.run.elements.config.ServiceResponse;
import com.manywho.sdk.entities.security.AuthenticatedWho;
import com.manywho.sdk.enums.InvokeType;
import com.manywho.sdk.utils.AuthorizationUtils;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequestWithBody;

import java.io.InputStream;
import java.net.URLEncoder;

// @todo Add notifier stuff to these methods
public class RunService {

    private String baseUrl = "https://flow.manywho.com";

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public EngineInitializationResponse initializeFlow(Notifier notifier, AuthenticatedWho authenticatedWho, String tenantId, EngineInitializationRequest engineInitializationRequest) throws Exception {
        return this.execute(authenticatedWho, tenantId, this.baseUrl + "/api/run/1", engineInitializationRequest, EngineInitializationResponse.class);
    }

    public EngineInvokeResponse executeFlow(Notifier notifier, AuthenticatedWho authenticatedWho, String tenantId, EngineInvokeRequest engineInvokeRequest) throws Exception {
        return this.execute(authenticatedWho, tenantId, this.baseUrl + "/api/run/1/state/" + engineInvokeRequest.getStateId(), engineInvokeRequest, EngineInvokeResponse.class);
    }

    public InvokeType sendEvent(Notifier notifier, AuthenticatedWho authenticatedWho, String tenantId, String callbackUri, ListenerServiceResponse listenerServiceResponse) throws Exception {
        return this.executeCallback(authenticatedWho, tenantId, callbackUri, listenerServiceResponse);
    }

    public InvokeType sendResponse(Notifier notifier, AuthenticatedWho authenticatedWho, String tenantId, String callbackUri, ServiceResponse serviceResponse) throws Exception {
        return this.executeCallback(authenticatedWho, tenantId, callbackUri, serviceResponse);
    }

    protected HttpRequestWithBody createHttpClient(AuthenticatedWho authenticatedWho, String tenantId, String callbackUri) throws Exception {
        String authorizationHeader = null;
        if (authenticatedWho != null) {
            authorizationHeader = URLEncoder.encode(AuthorizationUtils.serialize(authenticatedWho), "UTF-8");
        }

        return Unirest.post(callbackUri)
                .header("Authorization", authorizationHeader)
                .header("ManyWhoTenant", tenantId)
                .header("Content-Type", "application/json");
    }

    protected <T> T execute(AuthenticatedWho authenticatedWho, String tenantId, String callbackUri, Request request, Class<T> responseClass) throws Exception {
        InputStream body = this.createHttpClient(authenticatedWho, tenantId, callbackUri)
                .body(new ObjectMapper().configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true).writeValueAsString(request))
                .asJson()
                .getRawBody();

        return new ObjectMapper().configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true).readValue(body, responseClass);
    }

    protected InvokeType executeCallback(AuthenticatedWho authenticatedWho, String tenantId, String callbackUri, Response response) throws Exception {
        String responseBody = this.createHttpClient(authenticatedWho, tenantId, callbackUri)
                .body(new ObjectMapper().configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true).writeValueAsString(response))
                .asString()
                .getBody();

        return InvokeType.valueOf(responseBody.replace("\"", ""));
    }
}
