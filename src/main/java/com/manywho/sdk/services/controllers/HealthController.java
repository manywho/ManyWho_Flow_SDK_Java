package com.manywho.sdk.services.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class HealthController {
    @Path("/health")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String healthCheck() {
        return Response.Status.OK.name();
    }
}
