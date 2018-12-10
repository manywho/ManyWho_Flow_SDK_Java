package com.manywho.sdk.services.jaxrs.mappers;

import com.google.common.base.Joiner;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Map;
import java.util.stream.Collectors;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException e) {
        String message = "Validation errors occurred: ";

        Map<String, String> validationErrors = e.getConstraintViolations().stream()
                .collect(Collectors.toMap(
                        error -> error.getRootBeanClass().getSimpleName() + "." + error.getPropertyPath(),
                        error -> error.getMessage()
                ));

        message += Joiner.on(", ")
                .withKeyValueSeparator(": ")
                .join(validationErrors);

        if (message.length() > 500) {
            message = message.substring(0, 500);
        }

        return Response.status(400)
                .entity(message)
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}
