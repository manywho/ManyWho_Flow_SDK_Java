package com.manywho.sdk.services.controllers;

import com.manywho.sdk.entities.run.elements.config.ListenerServiceRequest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

public abstract class AbstractListenerController extends AbstractController {
    @Path("/listener")
    @POST
    public abstract void createListener(ListenerServiceRequest listenerServiceRequest) throws Exception;
}
