package com.manywho.sdk.services.jaxrs.mappers;

import com.manywho.sdk.api.run.ServiceProblem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.ParameterizedMessageFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DefaultExceptionMapper implements ExceptionMapper<Throwable> {
    private static final Logger LOGGER = LogManager.getLogger(new ParameterizedMessageFactory());

    @Context
    private UriInfo uriInfo;

    @Override
    public Response toResponse(Throwable e) {
        LOGGER.error("An exception occurred", e);

        Response.Status status = Response.Status.INTERNAL_SERVER_ERROR;
        if (e instanceof WebApplicationException) {
            status = Response.Status.fromStatusCode(((WebApplicationException) e).getResponse().getStatus());
        }

        String message = e.getMessage();
        if (message == null) {
            message = "A null pointer was encountered at " + e.getStackTrace()[0].toString();
        }

        if (message.length() > 500) {
            message = message.substring(0, 500);
        }

        ServiceProblem serviceProblem = new ServiceProblem(uriInfo.getRequestUri().getPath(), status.getStatusCode(), message);

        return Response.status(status)
                .entity(serviceProblem)
                .header("X-ManyWho-Service-Problem-Kind", serviceProblem.getKind())
                .build();
    }
}
