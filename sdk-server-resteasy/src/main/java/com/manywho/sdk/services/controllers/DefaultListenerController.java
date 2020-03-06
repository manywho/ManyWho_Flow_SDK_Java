package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.run.elements.config.ListenerServiceRequest;
import com.manywho.sdk.services.listeners.ListenerManager;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/listener")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DefaultListenerController {
    private final ListenerManager listenerManager;

    @Inject
    public DefaultListenerController(ListenerManager listenerManager) {
        this.listenerManager = listenerManager;
    }

    @POST
    public void create(@Valid @NotNull ListenerServiceRequest request) {
        listenerManager.create(request);
    }
}
