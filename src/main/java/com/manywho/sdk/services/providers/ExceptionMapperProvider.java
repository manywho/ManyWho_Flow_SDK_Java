package com.manywho.sdk.services.providers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.entities.run.elements.config.ServiceResponse;

import javax.inject.Inject;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;

@Provider
public class ExceptionMapperProvider implements javax.ws.rs.ext.ExceptionMapper<Exception> {
    @Inject
    private ObjectMapper objectMapper;

    @Override
    public Response toResponse(Exception e) {
        Map<String, String> rootFaults = new HashMap<>();
        rootFaults.put("error", e.getMessage());

        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setRootFaults(rootFaults);

        Response.Status status = Response.Status.INTERNAL_SERVER_ERROR;
        if (e instanceof ClientErrorException) {
            status = Response.Status.BAD_REQUEST;
        }

        try {
            return Response.status(
                    new CustomReasonPhraseExceptionStatusType(status, e.getMessage())
            ).entity(objectMapper.writeValueAsString(serviceResponse)).build();
        } catch (JsonProcessingException e1) {
            return Response.status(
                    new CustomReasonPhraseExceptionStatusType(status, e.getMessage())
            ).build();
        }
    }

    public static class CustomReasonPhraseExceptionStatusType implements Response.StatusType {

        private final Response.Status.Family family;
        private final int statusCode;
        private final String reasonPhrase;

        public CustomReasonPhraseExceptionStatusType(Response.Status httpStatus, String message) {
            this.family = httpStatus.getFamily();
            this.statusCode = httpStatus.getStatusCode();
            this.reasonPhrase = httpStatus.getReasonPhrase() + ": " + message;
        }

        @Override
        public int getStatusCode() {
            return statusCode;
        }

        @Override
        public Response.Status.Family getFamily() {
            return family;
        }

        @Override
        public String getReasonPhrase() {
            return reasonPhrase;
        }
    }
}

