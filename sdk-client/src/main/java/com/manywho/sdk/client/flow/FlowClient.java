package com.manywho.sdk.client.flow;

import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.draw.flow.FlowId;
import com.manywho.sdk.api.run.*;
import com.manywho.sdk.api.run.elements.map.MapElementInvokeRequest;
import com.manywho.sdk.client.run.RunClient;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class FlowClient {
    private final RunClient runClient;

    @Inject
    public FlowClient(RunClient runClient) {
        this.runClient = runClient;
    }

    /**
     * Start a flow with the given Tenant ID and Flow ID, using the default initialization options
     *
     * @param tenant    the ID of the Tenant that owns the Flow
     * @param id        the ID of the Flow
     * @return the initial state of the Flow
     */
    public FlowState start(UUID tenant, UUID id) {
        return start(tenant, id, null, new FlowInitializationOptions());
    }

    /**
     * Start a flow with the given Tenant ID and Flow ID, using the default initialization options
     *
     * @param tenant    the ID of the Tenant that owns the Flow
     * @param id        the ID of the Flow
     * @param version   the Version ID of the Flow
     * @return the initial state of the Flow
     */
    public FlowState start(UUID tenant, UUID id, UUID version) {
        return start(tenant, id, version, new FlowInitializationOptions());
    }

    /**
     * Start a flow with the given Tenant ID, Flow ID, Flow Version ID, and a set of initialization options.
     *
     * @param tenant    the ID of the Tenant that owns the Flow
     * @param id        the ID of the Flow
     * @param version   the Version ID of the Flow
     * @param options   a set of options for initializing the Flow
     * @return the initial state of the Flow
     */
    public FlowState start(UUID tenant, UUID id, UUID version, FlowInitializationOptions options) {
        if (options == null) {
            options = new FlowInitializationOptions();
        }

        // Create the inputs that we want to initialize the flow with
        List<EngineValue> inputs = options.getInputs().stream()
                .map(input -> {
                    if (input.hasObjectData()) {
                        return new EngineValue(input.getName(), input.getContentType(), input.getObjectData());
                    } else {
                        return new EngineValue(input.getName(), input.getContentType(), input.getContentValue());
                    }
                })
                .collect(Collectors.toList());

        // Set the required fields to initialize the flow
        EngineInitializationRequest initializationRequest = new EngineInitializationRequest();
        initializationRequest.setFlowId(new FlowId(id, version));
        initializationRequest.setInputs(inputs);
        initializationRequest.setMode(options.getMode().toString());

        try {
            // Actually initialize the flow
            EngineInitializationResponse response = runClient
                    .initialize(null, tenant, initializationRequest)
                    .execute()
                    .body();

            // Set the required fields to invoke the first step in the flow
            EngineInvokeRequest invokeRequest = new EngineInvokeRequest();
            invokeRequest.setCurrentMapElementId(response.getCurrentMapElementId());
            invokeRequest.setInvokeType(InvokeType.Forward);
            invokeRequest.setMapElementInvokeRequest(new MapElementInvokeRequest());
            invokeRequest.setStateId(response.getStateId());
            invokeRequest.setStateToken(response.getStateToken());

            // Actually invoke the flow
            EngineInvokeResponse invokeResponse = runClient
                    .execute(tenant, response.getStateId(), invokeRequest)
                    .execute()
                    .body();

            return new FlowState(runClient, tenant, invokeResponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
