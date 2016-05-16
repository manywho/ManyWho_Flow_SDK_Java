package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.run.elements.config.ListenerServiceRequest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public abstract class AbstractListenerController {
    @Path("/listener")
    @POST
    public abstract void createListener(ListenerServiceRequest listenerServiceRequest) throws Exception;
}
