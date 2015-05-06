package com.manywho.sdk.services.providers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.entities.run.ApiProblemException;
import com.manywho.sdk.entities.run.ServiceProblem;
import com.manywho.sdk.entities.run.ServiceProblemException;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApiProblemExceptionMapperProvider implements ExceptionMapper<ApiProblemException> {
    @Inject
    private ObjectMapper objectMapper;

    @Override
    public Response toResponse(ApiProblemException e) {
        ServiceProblem serviceProblem;
        if (e instanceof ServiceProblemException) {
            serviceProblem = new ServiceProblem(e, ((ServiceProblemException) e).getInvokeType(), ((ServiceProblemException) e).getAction());
        } else {
            serviceProblem = new ServiceProblem(e, null, null);
        }

        try {
            return Response.status(serviceProblem.getStatusCode())
                    .entity(objectMapper.writeValueAsString(serviceProblem))
                    .header("X-ManyWho-Service-Problem-Kind", serviceProblem.getKind())
                    .build();
        } catch (JsonProcessingException exception) {
            return Response.status(serviceProblem.getStatusCode()).build();
        }
    }
}

