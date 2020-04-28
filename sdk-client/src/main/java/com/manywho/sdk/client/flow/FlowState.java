package com.manywho.sdk.client.flow;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.EngineInvokeRequest;
import com.manywho.sdk.api.run.EngineInvokeResponse;
import com.manywho.sdk.api.run.elements.map.MapElementInvokeRequest;
import com.manywho.sdk.api.run.elements.map.MapElementInvokeResponse;
import com.manywho.sdk.api.run.elements.ui.PageRequest;
import com.manywho.sdk.api.run.elements.ui.PageResponse;
import com.manywho.sdk.client.flow.entities.Outcome;
import com.manywho.sdk.client.flow.entities.PageComponent;
import com.manywho.sdk.client.flow.entities.PageComponentUtils;
import com.manywho.sdk.client.run.RunClient;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class FlowState {
    private RunClient runClient;

    @JsonProperty
    private UUID tenant;

    @JsonProperty
    private EngineInvokeResponse invokeResponse;

    public FlowState() {
    }

    public FlowState(RunClient runClient, UUID tenant, EngineInvokeResponse invokeResponse) {
        this.tenant = tenant;
        this.runClient = runClient;
        this.invokeResponse = invokeResponse;
    }

    /**
     * Get the raw EngineInvokeResponse object for the current State
     *
     * @return the raw EngineInvokeResponse for the current State
     */
    public EngineInvokeResponse getInvokeResponse() {
        return invokeResponse;
    }

    /**
     * Get the Invoke Type of the current State
     *
     * @return the Invoke Type of the current State
     */
    public InvokeType getInvokeType() {
        return invokeResponse.getInvokeType();
    }

    /**
     * Get the State ID of the running Flow
     *
     * @return the State ID of the running Flow
     */
    public UUID getState() {
        return invokeResponse.getStateId();
    }

    /**
     * Get the Tenant ID of the running Flow
     *
     * @return the Tenant ID of the running Flow
     */
    public UUID getTenant() {
        return tenant;
    }

    /**
     * Check if the current step in the Flow has any components
     *
     * @return if the current step has any components
     */
    public boolean hasPageComponents() {
        return getPageResponse().getPageComponentResponses() != null &&
                !getPageResponse().getPageComponentResponses().isEmpty();
    }

    /**
     * Get a list of the components in the current step
     *
     * @return a list of the components in the current step
     */
    public List<PageComponent> getPageComponents() {
        return getPageResponse().getPageComponentResponses().stream()
                .map(componentResponse -> PageComponentUtils.createPageComponent(componentResponse, getPageResponse().getPageComponentDataResponses()))
                .collect(Collectors.toList());
    }

    /**
     * Check if the current step in the Flow has any outcomes
     *
     * @return if the current step has any outcomes
     */
    public boolean hasOutcomes() {
        return getMapElementInvokeResponse().getOutcomeResponses() != null &&
                !getMapElementInvokeResponse().getOutcomeResponses().isEmpty();
    }

    /**
     * Get a list of the outcomes on the current step in the Flow
     *
     * @return a list of the outcomes for the current step
     */
    public List<Outcome> getOutcomes() {
        return getMapElementInvokeResponse().getOutcomeResponses().stream()
                .map(Outcome::new)
                .collect(Collectors.toList());
    }

    /**
     * Select an outcome by it's name, then progress the Flow
     *
     * @param name the name of the outcome to select
     * @return the updated state of the Flow, after selecting the desired outcome
     */
    public FlowState selectOutcomeByName(String name) {
        Optional<Outcome> outcomeOptional = this.getOutcomes().stream()
                .filter(outcome -> outcome.getName().equals(name))
                .findFirst();

        if (!outcomeOptional.isPresent()) {
            throw new RuntimeException("An outcome with the name " + name + " could not be found");
        }

        return selectOutcome(outcomeOptional.get());
    }

    /**
     * Select a specific outcome in the current Flow's state, send any inputs, then progress
     *
     * @param outcome     the outcome to select in the Flow
     * @param pageRequest an object that contains the inputs that you wish to send to the Flow
     * @return the updated state of the Flow, after selecting the outcome and sending any inputs
     */
    public FlowState selectOutcome(UUID outcome, PageRequest pageRequest) {
        EngineInvokeRequest invokeRequest = new EngineInvokeRequest();
        invokeRequest.setCurrentMapElementId(invokeResponse.getCurrentMapElementId());
        invokeRequest.setInvokeType(InvokeType.Forward);
        invokeRequest.setMapElementInvokeRequest(new MapElementInvokeRequest(outcome, pageRequest));
        invokeRequest.setStateId(invokeResponse.getStateId());
        invokeRequest.setStateToken(invokeResponse.getStateToken());

        try {
            invokeResponse = runClient
                    .execute(tenant, invokeResponse.getStateId(), invokeRequest)
                    .execute()
                    .body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return this;
    }

    /**
     * Select a specific outcome in the current Flow's state, and progress
     *
     * @param outcome the outcome to select in the Flow
     * @return the updated state of the flow, after selecting the outcome
     */
    public FlowState selectOutcome(Outcome outcome) {
        return this.selectOutcome(outcome.getId(), null);
    }

    /**
     * Select a specific outcome in the current Flow's state, and progress
     *
     * @param id the outcome to select in the Flow
     * @return the updated state of the flow, after selecting the outcome
     */
    public FlowState selectOutcome(UUID id) {
        return this.selectOutcome(id, null);
    }

    /**
     * Tell the running state to SYNC, which synchronises the page metadata and state with this object again
     *
     * @return the updated state of the flow, after SYNCing
     */
    public FlowState sync() {
        EngineInvokeRequest invokeRequest = new EngineInvokeRequest();
        invokeRequest.setCurrentMapElementId(invokeResponse.getCurrentMapElementId());
        invokeRequest.setInvokeType(InvokeType.Sync);
        invokeRequest.setMapElementInvokeRequest(new MapElementInvokeRequest());
        invokeRequest.setStateId(invokeResponse.getStateId());
        invokeRequest.setStateToken(invokeResponse.getStateToken());

        PageResponse previousPageResponse = getPageResponse();

        try {
            invokeResponse = runClient
                    .execute(tenant, invokeResponse.getStateId(), invokeRequest)
                    .execute()
                    .body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // When SYNCing, ManyWho won't return the scaffolding, so we need to get it from the previous response if they exist
        if (previousPageResponse != null) {
            getPageResponse().setPageComponentResponses(previousPageResponse.getPageComponentResponses());
            getPageResponse().setPageContainerResponses(previousPageResponse.getPageContainerResponses());
        }

        return this;
    }

    private PageResponse getPageResponse() {
        return getMapElementInvokeResponse().getPageResponse();
    }

    private MapElementInvokeResponse getMapElementInvokeResponse() {
        return invokeResponse.getMapElementInvokeResponses().get(0);
    }
}

