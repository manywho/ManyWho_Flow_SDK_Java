package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.run.elements.config.ListenerServiceRequest;

public interface ListenerController {
    void createListener(ListenerServiceRequest listenerServiceRequest) throws Exception;
}
