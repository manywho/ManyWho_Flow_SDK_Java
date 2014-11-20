package com.manywho.sdk.services;

import com.manywho.sdk.entities.AuthenticatedWho;
import com.manywho.sdk.enums.AuthenticatedWhoToken;
import com.manywho.sdk.services.annotations.AuthorizationRequired;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Provider
@AuthorizationRequired
public class AuthorizationFilter implements ContainerRequestFilter {
    private static final String HEADER_NAME = "Authorization";

    private static String parseParameter(String parameter) {
        if (StringUtils.isNotEmpty(parameter)) {
            String[] param = parameter.split("=");

            if (param.length == 2) {
                return param[1];
            }
        }

        return "";
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String authorizationHeader = containerRequestContext.getHeaderString(HEADER_NAME);

        if (StringUtils.isNotEmpty(authorizationHeader)) {
            AuthenticatedWho authenticatedWho = this.deserializeAuthorizationHeader(authorizationHeader);

            // @todo Feels wrong having this check here
            if (StringUtils.isNotEmpty(authenticatedWho.getManyWhoTenantId())) {
                containerRequestContext.setProperty("AuthenticatedWho", authenticatedWho);
                return;
            }
        }

        containerRequestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());

    }

    private AuthenticatedWho deserializeAuthorizationHeader(String authorizationToken) throws UnsupportedEncodingException {
        AuthenticatedWho authenticatedWho = new AuthenticatedWho();

        String[] parameters = URLDecoder.decode(authorizationToken, StandardCharsets.UTF_8.name()).split("&");

        for (String parameter : Arrays.asList(parameters)) {
            parameter = parameter.trim();

            if (parameter.startsWith(AuthenticatedWhoToken.ManyWhoTenantId.toString())) {
                authenticatedWho.setManyWhoTenantId(parseParameter(parameter));
            } else if (parameter.startsWith(AuthenticatedWhoToken.ManyWhoUserId.toString())) {
                authenticatedWho.setManyWhoUserId(parseParameter(parameter));
            } else if (parameter.startsWith(AuthenticatedWhoToken.ManyWhoToken.toString())) {
                authenticatedWho.setManyWhoToken(parseParameter(parameter));
            } else if (parameter.startsWith(AuthenticatedWhoToken.DirectoryId.toString())) {
                authenticatedWho.setDirectoryId(parseParameter(parameter));
            } else if (parameter.startsWith(AuthenticatedWhoToken.DirectoryName.toString())) {
                authenticatedWho.setDirectoryName(parseParameter(parameter));
            } else if (parameter.startsWith(AuthenticatedWhoToken.Email.toString())) {
                authenticatedWho.setEmail(parseParameter(parameter));
            } else if (parameter.startsWith(AuthenticatedWhoToken.IdentityProvider.toString())) {
                authenticatedWho.setIdentityProvider(parseParameter(parameter));
            } else if (parameter.startsWith(AuthenticatedWhoToken.TenantName.toString())) {
                authenticatedWho.setTenantName(parseParameter(parameter));
            } else if (parameter.startsWith(AuthenticatedWhoToken.Token.toString())) {
                authenticatedWho.setToken(parseParameter(parameter));
            } else if (parameter.startsWith(AuthenticatedWhoToken.UserId.toString())) {
                authenticatedWho.setUserId(parseParameter(parameter));
            } else if (parameter.startsWith(AuthenticatedWhoToken.Username.toString())) {
                authenticatedWho.setUsername(parseParameter(parameter));
            } else if (parameter.startsWith(AuthenticatedWhoToken.FirstName.toString())) {
                authenticatedWho.setFirstName(parseParameter(parameter));
            } else if (parameter.startsWith(AuthenticatedWhoToken.LastName.toString())) {
                authenticatedWho.setLastName(parseParameter(parameter));
            }
        }

        return authenticatedWho;
    }
}
