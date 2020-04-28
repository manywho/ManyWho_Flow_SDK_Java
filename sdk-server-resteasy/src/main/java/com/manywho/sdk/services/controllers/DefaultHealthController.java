package com.manywho.sdk.services.controllers;

import com.manywho.sdk.services.health.HealthManager;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/health")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DefaultHealthController {
    private final HealthManager manager;

    @Inject
    public DefaultHealthController(HealthManager manager) {
        this.manager = manager;
    }

    @GET
    public Response checkHealth() {
        if (manager.isHealthy()) {
            return Response.ok().build();
        }

        return Response.serverError().build();
    }
}
