package com.manywho.sdk.client.raw;

import com.manywho.sdk.entities.draw.flow.FlowResponse;
import com.manywho.sdk.entities.run.EngineInitializationRequest;
import com.manywho.sdk.entities.run.EngineInitializationResponse;
import com.manywho.sdk.entities.run.EngineInvokeRequest;
import com.manywho.sdk.entities.run.EngineInvokeResponse;
import com.manywho.sdk.entities.security.AuthenticationCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.UUID;

public class RawRunClient extends AbstractClient {
    private static String BASE_URL = "https://flow.manywho.com/api/run/1";
    
    public RawRunClient() {
        super();
    }
    
    public RawRunClient(HttpClient httpClient) {
        super(httpClient);
    }

    public EngineInvokeResponse execute(UUID tenant, String authorization, EngineInvokeRequest invoke) {
        HttpPost request = new HttpPost(BASE_URL + "/state/" + invoke.getStateId());
        request.addHeader("Authorization", authorization);
        request.addHeader("ManyWhoTenant", tenant.toString());
        request.addHeader("Content-Type", MediaType.APPLICATION_JSON);
        request.setEntity(createEntity(invoke));

        return executeWithResponse(request, EngineInvokeResponse.class);
    }

    public EngineInitializationResponse initialize(
            UUID tenant,
            String authorization,
            EngineInitializationRequest initialization) {
        HttpPost request = new HttpPost(BASE_URL);
        request.addHeader("Authorization", authorization);
        request.addHeader("ManyWhoTenant", tenant.toString());
        request.addHeader("Content-Type", MediaType.APPLICATION_JSON);
        request.setEntity(createEntity(initialization));

        return executeWithResponse(request, EngineInitializationResponse.class);
    }

    public String authenticationCredentials(UUID stateId, UUID tenant, AuthenticationCredentials initializationRequest) {
        HttpPost request = new HttpPost(String.format("%s/authentication/%s", BASE_URL, stateId));
        request.addHeader("ManyWhoTenant", tenant.toString());
        request.addHeader("Content-Type", MediaType.APPLICATION_JSON);
        request.setEntity(createEntity(initializationRequest));

        return executeWithResponse(request, String.class);
    }

    public EngineInvokeResponse join(UUID tenant, UUID state, String authorization) {
        HttpGet request = new HttpGet(BASE_URL + "/state/" + state);
        request.addHeader("Authorization", authorization);
        request.addHeader("ManyWhoTenant", tenant.toString());
        request.addHeader("Content-Type", MediaType.APPLICATION_JSON);

        return executeWithResponse(request, EngineInvokeResponse.class);
    }

    public FlowResponse load(UUID tenant, UUID id) {
        HttpGet request = new HttpGet(BASE_URL + "/flow/" + id);
        request.addHeader("ManyWhoTenant", tenant.toString());

        return executeWithResponse(request, FlowResponse.class);
    }

    public List<FlowResponse> loadAll(UUID tenant, String filter) {
        URI uri = UriBuilder.fromPath(BASE_URL + "/flow")
                .queryParam("filter", filter)
                .build();

        HttpGet request = new HttpGet(uri);
        request.addHeader("ManyWhoTenant", tenant.toString());

        return executeWithListResponse(request, FlowResponse.class);
    }

    public List<FlowResponse> loadAll(UUID tenant) {
        return loadAll(tenant, "");
    }
}
