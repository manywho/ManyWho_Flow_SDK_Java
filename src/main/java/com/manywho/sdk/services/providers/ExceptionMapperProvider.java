package com.manywho.sdk.services.providers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.entities.run.ServiceProblem;

import javax.inject.Inject;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionMapperProvider implements ExceptionMapper<Exception> {
    @Inject
    private ObjectMapper objectMapper;

    @Context
    private UriInfo uriInfo;

    @Override
    public Response toResponse(Exception e) {
        Response.Status status = Response.Status.INTERNAL_SERVER_ERROR;
        if (e instanceof ClientErrorException) {
            status = Response.Status.BAD_REQUEST;
        }

        String message = e.getMessage();
        if (message == null) {
            message = "A null pointer was encountered";
        }

        if (message.length() > 500) {
            message = message.substring(0, 500);
        }

        ServiceProblem serviceProblem = new ServiceProblem(uriInfo.getRequestUri().getPath(), status.getStatusCode(), message);

        try {
            return Response.status(status)
                    .entity(objectMapper.writeValueAsString(serviceProblem))
                    .header("X-ManyWho-Service-Problem-Kind", serviceProblem.getKind())
                    .build();
        } catch (JsonProcessingException e1) {
            return Response.status(status).build();
        }
    }
}

