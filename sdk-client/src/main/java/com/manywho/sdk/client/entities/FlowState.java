package com.manywho.sdk.client.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.manywho.sdk.client.RunClient;
import com.manywho.sdk.entities.run.EngineInvokeRequest;
import com.manywho.sdk.entities.run.EngineInvokeResponse;
import com.manywho.sdk.entities.run.elements.map.MapElementInvokeRequest;
import com.manywho.sdk.entities.run.elements.map.MapElementInvokeResponse;
import com.manywho.sdk.entities.run.elements.ui.PageComponentDataResponse;
import com.manywho.sdk.entities.run.elements.ui.PageComponentResponse;
import com.manywho.sdk.entities.run.elements.ui.PageRequest;
import com.manywho.sdk.entities.run.elements.ui.PageResponse;
import com.manywho.sdk.enums.InvokeType;
import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlowState {
    @JsonProperty
    private String tenantId;
    private RunClient runClient;
    @JsonProperty
    private EngineInvokeResponse invokeResponse;

    public FlowState() {
    }

    public FlowState(RunClient runClient, String tenantId, EngineInvokeResponse invokeResponse) {
        this.tenantId = tenantId;
        this.runClient = runClient;
        this.invokeResponse = invokeResponse;
    }

    private static PageComponent createPageComponent(PageComponentResponse componentResponse, List<PageComponentDataResponse> componentDataResponses) {
        PageComponent pageComponent = new PageComponent();
        pageComponent.setAttributes(componentResponse.getAttributes());
        pageComponent.setContentType(componentResponse.getContentType());
        pageComponent.setId(componentResponse.getId());
        pageComponent.setName(componentResponse.getDeveloperName());
        pageComponent.setOrder(componentResponse.getOrder());
        pageComponent.setType(componentResponse.getComponentType());

        // See if there is a corresponding PageComponentDataResponse for the current component
        Optional<PageComponentDataResponse> componentData = componentDataResponses.stream()
                .filter(componentDataResponse -> componentDataResponse.getPageComponentId().equals(componentResponse.getId()))
                .findFirst();

        if (componentData.isPresent()) {
            PageComponentDataResponse componentDataResponse = componentData.get();

            PageComponent.Data pageComponentData = new PageComponent.Data()
                    .setContent(componentDataResponse.getContent())
                    .setContentValue(componentDataResponse.getContentValue())
                    .setEditable(componentDataResponse.isEditable())
                    .setEnabled(componentDataResponse.isEnabled())
                    .setFileDataRequest(componentDataResponse.getFileDataRequest())
                    .setObjectData(componentDataResponse.getObjectData())
                    .setObjectDataRequest(componentDataResponse.getObjectDataRequest())
                    .setRequired(componentDataResponse.isRequired())
                    .setVisible(componentDataResponse.isVisible());

            pageComponent.setData(pageComponentData);
        }

        return pageComponent;
    }

    // TODO: Probably remove this method
    public EngineInvokeResponse getInvokeResponse() {
        return invokeResponse;
    }

    public InvokeType getInvokeType() {
        return invokeResponse.getInvokeType();
    }

    public String getStateId() {
        return invokeResponse.getStateId();
    }

    public String getTenantId() {
        return tenantId;
    }

    private PageResponse getPageResponse() {
        return getMapElementInvokeResponse().getPageResponse();
    }

    private MapElementInvokeResponse getMapElementInvokeResponse() {
        return invokeResponse.getMapElementInvokeResponses().get(0);
    }

    public boolean hasPageComponents() {
        return CollectionUtils.isNotEmpty(getPageResponse().getPageComponentResponses());
    }

    public List<PageComponent> getPageComponents() {
        return getPageResponse().getPageComponentResponses().stream()
                .map(componentResponse -> createPageComponent(componentResponse, getPageResponse().getPageComponentDataResponses()))
                .collect(Collectors.toList());
    }

    public boolean hasOutcomes() {
        return CollectionUtils.isNotEmpty(getMapElementInvokeResponse().getOutcomeResponses());
    }

    public List<Outcome> getOutcomes() {
        return getMapElementInvokeResponse().getOutcomeResponses().stream()
                .map(Outcome::new)
                .collect(Collectors.toList());
    }

    public FlowState selectOutcomeByName(String name) throws IOException, URISyntaxException {
        Optional<Outcome> outcomeOptional = this.getOutcomes().stream()
                .filter(outcome -> outcome.getName().equals(name))
                .findFirst();

        if (!outcomeOptional.isPresent()) {
            throw new RuntimeException("An outcome with the name " + name + " could not be found");
        }

        return selectOutcome(outcomeOptional.get());
    }

    public FlowState selectOutcome(Outcome outcome, PageRequest pageRequest) throws IOException, URISyntaxException {
        EngineInvokeRequest invokeRequest = new EngineInvokeRequest();
        invokeRequest.setCurrentMapElementId(invokeResponse.getCurrentMapElementId());
        invokeRequest.setInvokeType(InvokeType.Forward);
        invokeRequest.setMapElementInvokeRequest(new MapElementInvokeRequest(outcome.getId(), pageRequest));
        invokeRequest.setStateId(invokeResponse.getStateId());
        invokeRequest.setStateToken(invokeResponse.getStateToken());

        invokeResponse = runClient.executeFlow(this.tenantId, null, invokeRequest);

        return this;
    }

    public FlowState selectOutcome(Outcome outcome) throws IOException, URISyntaxException {
        return this.selectOutcome(outcome, null);
    }

    public FlowState sync() throws IOException, URISyntaxException {
        EngineInvokeRequest invokeRequest = new EngineInvokeRequest();
        invokeRequest.setCurrentMapElementId(invokeResponse.getCurrentMapElementId());
        invokeRequest.setInvokeType(InvokeType.Sync);
        invokeRequest.setMapElementInvokeRequest(new MapElementInvokeRequest());
        invokeRequest.setStateId(invokeResponse.getStateId());
        invokeRequest.setStateToken(invokeResponse.getStateToken());

        PageResponse previousPageResponse = getPageResponse();

        invokeResponse = runClient.executeFlow(this.tenantId, null, invokeRequest);

        // When SYNCing, ManyWho won't return the scaffolding, so we need to get it from the previous response if they exist
        if (previousPageResponse != null) {
            getPageResponse().setPageComponentResponses(previousPageResponse.getPageComponentResponses());
            getPageResponse().setPageContainerResponses(previousPageResponse.getPageContainerResponses());
        }

        return this;
    }
}
