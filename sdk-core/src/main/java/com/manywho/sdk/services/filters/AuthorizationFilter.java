package com.manywho.sdk.services.filters;

import com.manywho.sdk.utils.AuthorizationUtils;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@PreMatching
public class AuthorizationFilter implements ContainerRequestFilter {
    private static final String HEADER_NAME = "Authorization";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authorizationHeader = requestContext.getHeaderString(HEADER_NAME);

        String path = requestContext.getUriInfo().getPath();
        if (path.equals("authentication") ||
            path.equals("authorization/group") ||
            path.equals("authorization/group/attribute") ||
            path.equals("authorization/user") ||
            path.equals("authorization/user/attribute") ||
            path.contains("webhook")) {
            return;
        }

        if (StringUtils.isNotEmpty(authorizationHeader)) {
            requestContext.setProperty("AuthenticatedWho", AuthorizationUtils.deserialize(authorizationHeader));
            return;
        }

        requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
    }
}
