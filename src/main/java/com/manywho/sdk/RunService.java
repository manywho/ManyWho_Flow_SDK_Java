package com.manywho.sdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.entities.run.elements.config.ListenerServiceResponse;
import com.manywho.sdk.entities.security.AuthenticatedWho;
import com.manywho.sdk.enums.InvokeType;
import com.manywho.sdk.utils.AuthorizationUtils;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequestWithBody;

public class RunService {

    public InvokeType sendEvent(AuthenticatedWho authenticatedWho, String tenantId, String callbackUri, ListenerServiceResponse listenerServiceResponse) throws Exception {
        HttpRequestWithBody request = Unirest.post(callbackUri);
        request.header("Authorization", AuthorizationUtils.serialize(authenticatedWho));
        request.header("ManyWhoTenant", tenantId);
        request.header("Content-Type", "application/json");

        request.body(new ObjectMapper().writeValueAsString(listenerServiceResponse));

        return InvokeType.valueOf(request.asString().getBody());
    }
}
