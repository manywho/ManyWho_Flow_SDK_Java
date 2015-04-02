package com.manywho.sdk.services.providers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.entities.run.elements.config.ServiceResponse;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;

@Provider
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Exception> {
    @Inject
    private ObjectMapper objectMapper;

    @Override
    public Response toResponse(Exception e) {
        Map<String, String> rootFaults = new HashMap<>();
        rootFaults.put("error", e.getMessage());

        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setRootFaults(rootFaults);

        try {
            return Response.status(
                    new CustomReasonPhraseExceptionStatusType(Response.Status.INTERNAL_SERVER_ERROR, e.getMessage())
            ).entity(objectMapper.writeValueAsString(serviceResponse)).build();
        } catch (JsonProcessingException e1) {
            return Response.status(
                    new CustomReasonPhraseExceptionStatusType(Response.Status.INTERNAL_SERVER_ERROR, e.getMessage())
            ).build();
        }
    }
}

