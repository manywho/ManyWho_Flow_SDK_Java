package com.manywho.sdk.client;

import com.manywho.sdk.client.entities.FlowState;
import com.manywho.sdk.client.options.FlowInitializationOptions;
import com.manywho.sdk.entities.draw.flow.FlowId;
import com.manywho.sdk.entities.draw.flow.FlowResponse;
import com.manywho.sdk.entities.run.EngineInitializationRequest;
import com.manywho.sdk.entities.run.EngineInitializationResponse;
import com.manywho.sdk.entities.run.EngineInvokeRequest;
import com.manywho.sdk.entities.run.EngineInvokeResponse;
import com.manywho.sdk.entities.run.elements.map.MapElementInvokeRequest;
import com.manywho.sdk.enums.InvokeType;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static com.manywho.sdk.services.providers.ObjectMapperProvider.getObjectMapper;

public class RunClient extends AbstractClient {
    public FlowState startFlow(String tenantId, FlowId flowId, FlowInitializationOptions options) throws IOException, URISyntaxException {
        EngineInitializationRequest initializationRequest = new EngineInitializationRequest();
        initializationRequest.setFlowId(flowId);
        initializationRequest.setMode(options.getMode().toString());

        EngineInitializationResponse response = initializeFlow(tenantId, null, initializationRequest);

        EngineInvokeRequest invokeRequest = new EngineInvokeRequest();
        invokeRequest.setCurrentMapElementId(response.getCurrentMapElementId());
        invokeRequest.setInvokeType(InvokeType.Forward);
        invokeRequest.setMapElementInvokeRequest(new MapElementInvokeRequest());
        invokeRequest.setStateId(response.getStateId());
        invokeRequest.setStateToken(response.getStateToken());

        EngineInvokeResponse invokeResponse = executeFlow(tenantId, null, invokeRequest);

        return new FlowState(this, tenantId, invokeResponse);
    }

    public FlowState joinFlow(String tenantId, String stateId, String authorizationToken) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(baseUri + "/state/" + stateId).build();

        HttpGet request = new HttpGet(uri);
        request.addHeader("Authorization", authorizationToken);
        request.addHeader("ManyWhoTenant", tenantId);
        request.addHeader("Content-Type", MediaType.APPLICATION_JSON);

        EngineInvokeResponse invokeResponse = executeWithResponse(request, EngineInvokeResponse.class);

        return new FlowState(this, tenantId, invokeResponse);
    }

    public EngineInitializationResponse initializeFlow(
            String tenantId,
            String authorizationToken,
            EngineInitializationRequest initializationRequest) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(baseUri).build();

        HttpPost request = new HttpPost(uri);
        request.addHeader("Authorization", authorizationToken);
        request.addHeader("ManyWhoTenant", tenantId);
        request.addHeader("Content-Type", MediaType.APPLICATION_JSON);
        request.setEntity(new ByteArrayEntity(getObjectMapper().writeValueAsBytes(initializationRequest)));

        return executeWithResponse(request, EngineInitializationResponse.class);
    }

    public EngineInvokeResponse executeFlow(String tenantId, String authorizationToken, EngineInvokeRequest invokeRequest) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(baseUri + "/state/" + invokeRequest.getStateId()).build();

        HttpPost request = new HttpPost(uri);
        request.addHeader("Authorization", authorizationToken);
        request.addHeader("ManyWhoTenant", tenantId);
        request.addHeader("Content-Type", MediaType.APPLICATION_JSON);
        request.setEntity(new ByteArrayEntity(getObjectMapper().writeValueAsBytes(invokeRequest)));

        return executeWithResponse(request, EngineInvokeResponse.class);
    }

    public List<FlowResponse> loadFlows(String tenantId) throws IOException, URISyntaxException {
        return loadFlows(tenantId, "");
    }

    public List<FlowResponse> loadFlows(String tenantId, String filter) throws IOException, URISyntaxException {
        URI uri = new URIBuilder(baseUri + "/flow")
                .addParameter("filter", filter)
                .build();

        HttpGet request = new HttpGet(uri);
        request.addHeader("ManyWhoTenant", tenantId);

        return executeWithListResponse(request, FlowResponse.class);
    }

    public FlowResponse loadFlowById(String tenantId, String id) throws URISyntaxException, IOException {
        URI uri = new URIBuilder(baseUri + "/flow/" + id)
                .build();

        HttpGet request = new HttpGet(uri);
        request.addHeader("ManyWhoTenant", tenantId);

        return executeWithResponse(request, FlowResponse.class);
    }
}
