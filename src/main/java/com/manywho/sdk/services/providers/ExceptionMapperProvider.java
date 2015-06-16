package com.manywho.sdk.services.providers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.entities.run.ServiceProblem;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionMapperProvider implements ExceptionMapper<Exception> {
    @Inject
    private ObjectMapper objectMapper;

    @Context
    private HttpServletRequest request;

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

        ServiceProblem serviceProblem = new ServiceProblem(request.getRequestURI(), status.getStatusCode(), message.substring(0, 500));

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

