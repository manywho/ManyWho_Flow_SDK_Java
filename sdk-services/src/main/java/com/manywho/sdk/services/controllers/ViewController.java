package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.run.elements.config.UiServiceRequest;
import com.manywho.sdk.api.run.elements.config.UiServiceResponse;

public interface ViewController {
    UiServiceResponse view(String name, UiServiceRequest request) throws Exception;
}
