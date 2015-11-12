package com.manywho.sdk.services.providers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.entities.run.ApiProblem;
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
        ApiProblem apiProblem;
        if (e instanceof ServiceProblemException) {
            apiProblem = new ServiceProblem(e, ((ServiceProblemException) e).getInvokeType(), ((ServiceProblemException) e).getAction());
        } else {
            apiProblem = new ApiProblem(e);
        }

        try {
            return Response.status(apiProblem.getStatusCode())
                    .entity(objectMapper.writeValueAsString(apiProblem))
                    .header("X-ManyWho-Service-Problem-Kind", apiProblem.getKind())
                    .build();
        } catch (JsonProcessingException exception) {
            return Response.status(apiProblem.getStatusCode()).build();
        }
    }
}

