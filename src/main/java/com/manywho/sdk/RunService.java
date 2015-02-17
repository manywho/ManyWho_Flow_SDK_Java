package com.manywho.sdk;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.manywho.sdk.entities.draw.flow.FlowResponse;
import com.manywho.sdk.entities.security.AuthenticationCredentials;
import com.manywho.sdk.services.notifications.Notifier;
import com.manywho.sdk.entities.run.*;
import com.manywho.sdk.entities.run.elements.config.ListenerServiceResponse;
import com.manywho.sdk.entities.run.elements.config.ServiceResponse;
import com.manywho.sdk.entities.security.AuthenticatedWho;
import com.manywho.sdk.enums.InvokeType;
import com.manywho.sdk.utils.AuthorizationUtils;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequestWithBody;

import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// @todo Add notifier stuff to these methods
public class RunService {
    private static final Set<Integer> STATUSES_SUCCESS = new HashSet<Integer>(Arrays.asList(
        new Integer[] {200, 201, 202, 203, 204, 205, 206, 207, 208, 226}
    ));

    private String baseUrl = "https://flow.manywho.com";

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public AuthenticatedWho login(Notifier notifier, String tenantId, String stateId, AuthenticationCredentials authenticationCredentials) throws Exception {
        String authenticationToken = this.executePost(null, tenantId, this.baseUrl + "/api/run/1/authentication/" + stateId, authenticationCredentials);

        String tokenToDeserialize = URLDecoder.decode(authenticationToken.substring(1, authenticationToken.length() - 1), "UTF-8");

        return AuthorizationUtils.deserialize(tokenToDeserialize);
    }

    public FlowResponse loadFlow(Notifier notifier, AuthenticatedWho authenticatedWho, String tenantId, String flowId) throws Exception {
        return this.executeGet(authenticatedWho, tenantId, this.baseUrl + "/api/run/1/flow/" + flowId, FlowResponse.class);
    }

    public FlowResponse loadFlowByName(Notifier notifier, AuthenticatedWho authenticatedWho, String tenantId, String flowName) throws Exception {
        return this.executeGet(authenticatedWho, tenantId, this.baseUrl + "/api/run/1/flow/name/" + flowName, FlowResponse.class);
    }

    public EngineInitializationResponse initializeFlow(Notifier notifier, AuthenticatedWho authenticatedWho, String tenantId, EngineInitializationRequest engineInitializationRequest) throws Exception {
        return this.executePost(authenticatedWho, tenantId, this.baseUrl + "/api/run/1", engineInitializationRequest, EngineInitializationResponse.class);
    }

    public EngineInvokeResponse executeFlow(Notifier notifier, AuthenticatedWho authenticatedWho, String tenantId, EngineInvokeRequest engineInvokeRequest) throws Exception {
        return this.executePost(authenticatedWho, tenantId, this.baseUrl + "/api/run/1/state/" + engineInvokeRequest.getStateId(), engineInvokeRequest, EngineInvokeResponse.class);
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

    protected <T> T executeGet(AuthenticatedWho authenticatedWho, String tenantId, String uri, Class<T> responseClass) throws Exception {
        String authorizationHeader = null;
        if (authenticatedWho != null) {
            authorizationHeader = URLEncoder.encode(AuthorizationUtils.serialize(authenticatedWho), "UTF-8");
        }

        HttpResponse response = Unirest.get(uri)
                .header("Authorization", authorizationHeader)
                .header("ManyWhoTenant", tenantId)
                .asJson();

        if (!STATUSES_SUCCESS.contains(response.getStatus())) {
            throw new Exception(response.getStatusText());
        }

        return new ObjectMapper().configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true).readValue(response.getRawBody(), responseClass);
    }

    protected <T> T executePost(AuthenticatedWho authenticatedWho, String tenantId, String callbackUri, Request request, Class<T> responseClass) throws Exception {
        HttpResponse response = this.createHttpClient(authenticatedWho, tenantId, callbackUri)
                .body(new ObjectMapper().configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true).writeValueAsString(request))
                .asJson();

        if (!STATUSES_SUCCESS.contains(response.getStatus())) {
            throw new Exception(response.getStatusText());
        }

        return new ObjectMapper().configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true).readValue(response.getRawBody(), responseClass);
    }

    protected String executePost(AuthenticatedWho authenticatedWho, String tenantId, String callbackUri, Request request) throws Exception {
        HttpResponse<String> response = this.createHttpClient(authenticatedWho, tenantId, callbackUri)
                .body(new ObjectMapper().configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true).writeValueAsString(request))
                .asString();

        if (!STATUSES_SUCCESS.contains(response.getStatus())) {
            throw new Exception(response.getStatusText());
        }

        return response.getBody();
    }

    protected InvokeType executeCallback(AuthenticatedWho authenticatedWho, String tenantId, String callbackUri, Response response) throws Exception {
        String responseBody = this.createHttpClient(authenticatedWho, tenantId, callbackUri)
                .body(new ObjectMapper().configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true).writeValueAsString(response))
                .asString()
                .getBody();

        return InvokeType.fromString(responseBody.replace("\"", ""));
    }
}
