package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.api.run.elements.config.ServiceResponse;
import com.manywho.sdk.services.actions.ActionManager;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/actions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DefaultActionController {
    private final ActionManager actionManager;

    @Inject
    public DefaultActionController(ActionManager actionManager) {
        this.actionManager = actionManager;
    }

    @Path("/{name: .+}")
    @POST
    public ServiceResponse executeAction(@PathParam("name") String name, ServiceRequest serviceRequest) {
        return actionManager.executeAction(name, serviceRequest);
    }
}
