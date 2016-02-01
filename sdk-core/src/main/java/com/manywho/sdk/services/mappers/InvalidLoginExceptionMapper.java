package com.manywho.sdk.services.mappers;

import com.manywho.sdk.entities.security.AuthenticatedWhoResult;
import com.manywho.sdk.exceptions.InvalidLoginException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InvalidLoginExceptionMapper implements ExceptionMapper<InvalidLoginException> {
    @Override
    public Response toResponse(InvalidLoginException e) {
        AuthenticatedWhoResult result = AuthenticatedWhoResult.createDeniedResult();
        result.setStatusMessage(e.getMessage());

        return Response.status(Response.Status.OK)
                .entity(result)
                .build();
    }
} 
