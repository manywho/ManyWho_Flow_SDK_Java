package com.manywho.sdk;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.rholder.retry.Retryer;
import com.github.rholder.retry.RetryerBuilder;
import com.github.rholder.retry.StopStrategies;
import com.github.rholder.retry.WaitStrategies;
import com.google.common.base.Predicate;
import com.manywho.sdk.entities.draw.flow.FlowResponse;
import com.manywho.sdk.entities.draw.flow.FlowResponseCollection;
import com.manywho.sdk.entities.run.*;
import com.manywho.sdk.entities.run.elements.config.ListenerServiceResponse;
import com.manywho.sdk.entities.run.elements.config.ServiceResponse;
import com.manywho.sdk.entities.security.AuthenticatedWho;
import com.manywho.sdk.entities.security.AuthenticationCredentials;
import com.manywho.sdk.enums.InvokeType;
import com.manywho.sdk.services.notifications.Notifier;
import com.manywho.sdk.utils.AuthorizationUtils;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequestWithBody;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

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

    public FlowResponseCollection loadFlows(Notifier notifier, AuthenticatedWho authenticatedWho, String tenantId) throws Exception {
        return this.executeGet(authenticatedWho, tenantId, this.baseUrl + "/api/run/1/flow", FlowResponseCollection.class);
    }

    public FlowResponseCollection loadFlows(Notifier notifier, AuthenticatedWho authenticatedWho, String tenantId, String filter) throws Exception {
        return this.executeGet(authenticatedWho, tenantId, this.baseUrl + "/api/run/1/flow", new HashMap<String, Object>() {{
            put("filter", filter);
        }}, FlowResponseCollection.class);
    }

    public EngineInitializationResponse initializeFlow(Notifier notifier, AuthenticatedWho authenticatedWho, String tenantId, EngineInitializationRequest engineInitializationRequest) throws Exception {
        return this.executePost(authenticatedWho, tenantId, this.baseUrl + "/api/run/1", engineInitializationRequest, EngineInitializationResponse.class);
    }

    public EngineInvokeResponse executeFlow(Notifier notifier, AuthenticatedWho authenticatedWho, String tenantId, EngineInvokeRequest engineInvokeRequest) throws Exception {
        Callable<EngineInvokeResponse> executeCallable = () -> this.executePost(
                authenticatedWho,
                tenantId,
                this.baseUrl + "/api/run/1/state/" + engineInvokeRequest.getStateId(),
                engineInvokeRequest,
                EngineInvokeResponse.class
        );

        return RunService.<EngineInvokeResponse>createRetry(response -> response.getInvokeType().equals(InvokeType.Busy))
                .call(executeCallable);
    }

    public EngineInvokeResponse joinFlow(Notifier notifier, AuthenticatedWho authenticatedWho, String tenantId, String stateId) throws Exception {
        return this.executeGet(authenticatedWho, tenantId, this.baseUrl + "/api/run/1/state/" + stateId, EngineInvokeResponse.class);
    }

    public InvokeType sendEvent(Notifier notifier, AuthenticatedWho authenticatedWho, String tenantId, String callbackUri, ListenerServiceResponse listenerServiceResponse) throws Exception {
        return this.executeCallback(authenticatedWho, tenantId, callbackUri, listenerServiceResponse);
    }

    public InvokeType sendResponse(Notifier notifier, AuthenticatedWho authenticatedWho, String tenantId, String callbackUri, ServiceResponse serviceResponse) throws Exception {
        Callable<InvokeType> executeCallable = () -> this.executeCallback(
                authenticatedWho,
                tenantId,
                callbackUri,
                serviceResponse
        );

        return RunService.<InvokeType>createRetry(invokeType -> invokeType.equals(InvokeType.Busy))
                .call(executeCallable);
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
        return executeGet(authenticatedWho, tenantId, uri, null, responseClass);
    }

    protected <T> T executeGet(AuthenticatedWho authenticatedWho, String tenantId, String uri, Map<String, Object> queryParameters, Class<T> responseClass) throws Exception {
        String authorizationHeader = null;
        if (authenticatedWho != null) {
            authorizationHeader = URLEncoder.encode(AuthorizationUtils.serialize(authenticatedWho), "UTF-8");
        }

        HttpResponse response = Unirest.get(uri)
                .header("Authorization", authorizationHeader)
                .header("ManyWhoTenant", tenantId)
                .queryString(queryParameters)
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

    public static <T> Retryer<T> createRetry(Predicate<T> predicate) {
        // If the invoke type is BUSY, then retry 4 times, with an exponential backoff of 500ms and a 2x multiplier
        return RetryerBuilder.<T>newBuilder()
                .retryIfResult(predicate)
                .withWaitStrategy(WaitStrategies.exponentialWait(2, 500, TimeUnit.MILLISECONDS))
                .withStopStrategy(StopStrategies.stopAfterAttempt(4))
                .build();
    }
}
