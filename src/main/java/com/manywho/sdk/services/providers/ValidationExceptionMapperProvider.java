package com.manywho.sdk.services.providers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.entities.run.elements.config.ServiceResponse;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.HashMap;
import java.util.Map;

@Provider
public class ValidationExceptionMapperProvider implements ExceptionMapper<ConstraintViolationException> {
    @Inject
    private ObjectMapper objectMapper;

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        Map<String, String> rootFaults = new HashMap<String, String>() {{
            exception.getConstraintViolations().forEach(v -> put(v.getPropertyPath().toString(), v.getMessage()));
        }};

        ServiceResponse serviceResponse = new ServiceResponse() {{
            setRootFaults(rootFaults);
        }};

        try {
            return Response.status(400).type(MediaType.APPLICATION_JSON_TYPE).entity(objectMapper.writeValueAsString(serviceResponse)).build();
        } catch (Exception ex) {
            return Response.status(400).build();
        }
    }
}
