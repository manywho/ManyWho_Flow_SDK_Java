package com.manywho.sdk.client;

import com.manywho.sdk.client.entities.FlowState;
import com.manywho.sdk.client.options.FlowInitializationOptions;
import com.manywho.sdk.client.raw.RawRunClient;
import com.manywho.sdk.entities.draw.flow.FlowId;
import com.manywho.sdk.entities.run.EngineInitializationRequest;
import com.manywho.sdk.entities.run.EngineInitializationResponse;
import com.manywho.sdk.entities.run.EngineInvokeRequest;
import com.manywho.sdk.entities.run.EngineInvokeResponse;
import com.manywho.sdk.entities.run.elements.map.MapElementInvokeRequest;
import com.manywho.sdk.enums.InvokeType;
import com.manywho.sdk.utils.AuthorizationUtils;

import java.util.UUID;

public class FlowClient {
    private final RawRunClient rawRunClient;

    public FlowClient() {
        this.rawRunClient = new RawRunClient();
    }

    public FlowClient(final RawRunClient rawRunClient) {
        this.rawRunClient = rawRunClient;
    }

    /**
     * Join a currently running Flow as a public user, using the given Tenant ID and State ID.
     *
     * @param tenant the ID of the Tenant that owns the Flow
     * @param state  the ID of the state to be joined
     * @return the current state of the Flow
     */
    public FlowState join(UUID tenant, UUID state) {
        return join(tenant, state, AuthorizationUtils.createSerializedPublicUser(tenant));
    }

    /**
     * Join a currently running Flow with the given Tenant ID, State ID and authorization token.
     *
     * @param tenant             the ID of the Tenant that owns the Flow
     * @param state              the ID of the state to be joined
     * @param authorizationToken the authorization token to allow access to the Flow
     * @return the current state of the Flow
     */
    public FlowState join(UUID tenant, UUID state, String authorizationToken) {
        EngineInvokeResponse invokeResponse = rawRunClient.join(tenant, state, authorizationToken);

        return new FlowState(rawRunClient, tenant, invokeResponse);
    }

    /**
     * Start a flow with the given Tenant ID and Flow ID, using the default initialization options
     *
     * @param tenant    the ID of the Tenant that owns the Flow
     * @param id        the ID of the Flow
     * @return the initial state of the Flow
     */
    public FlowState start(UUID tenant, FlowId id) {
        return start(tenant, id, new FlowInitializationOptions());
    }

    /**
     * Start a flow with the given Tenant ID and Flow ID, and a set of initialization options.
     *
     * @param tenant  the ID of the Tenant that owns the Flow
     * @param id      the ID of the Flow
     * @param options a set of options for initializing the Flow
     * @return the initial state of the Flow
     */
    public FlowState start(UUID tenant, FlowId id, FlowInitializationOptions options) {
        if (options == null) {
            options = new FlowInitializationOptions();
        }

        EngineInitializationRequest initializationRequest = new EngineInitializationRequest();
        initializationRequest.setFlowId(id);
        initializationRequest.setMode(options.getMode().toString());

        EngineInitializationResponse response = rawRunClient.initialize(tenant, null, initializationRequest);

        EngineInvokeRequest invokeRequest = new EngineInvokeRequest();
        invokeRequest.setCurrentMapElementId(response.getCurrentMapElementId());
        invokeRequest.setInvokeType(InvokeType.Forward);
        invokeRequest.setMapElementInvokeRequest(new MapElementInvokeRequest());
        invokeRequest.setStateId(response.getStateId());
        invokeRequest.setStateToken(response.getStateToken());

        EngineInvokeResponse invokeResponse = rawRunClient.execute(tenant, null, invokeRequest);

        return new FlowState(rawRunClient, tenant, invokeResponse);
    }
}
