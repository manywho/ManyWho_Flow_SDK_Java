package com.manywho.sdk.services.providers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.entities.run.ServiceProblem;
import com.manywho.sdk.entities.run.elements.config.ServiceResponse;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Context;
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

    @Context
    private HttpServletRequest request;

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        String message = "Validation errors occurred: ";
        Map<String, String> validationErrors = new HashMap<String, String>() {{
            exception.getConstraintViolations().forEach(v -> put(v.getPropertyPath().toString(), v.getMessage()));
        }};

        message = message + StringUtils.join(validationErrors, ", ");

        if (message.length() > 500) {
            message = message.substring(0, 500);
        }

        ServiceProblem serviceProblem = new ServiceProblem(request.getRequestURI(), 400, message);

        try {
            return Response.status(400)
                    .entity(objectMapper.writeValueAsString(serviceProblem))
                    .header("X-ManyWho-Service-Problem-Kind", serviceProblem.getKind())
                    .build();
        } catch (JsonProcessingException e1) {
            return Response.status(400).build();
        }
    }
}
