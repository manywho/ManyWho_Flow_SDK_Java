package com.manywho.sdk.services.identity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.CaseFormat;
import com.google.common.base.Splitter;
import com.manywho.sdk.api.security.AuthenticatedWho;

import javax.inject.Inject;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import java.util.stream.Collectors;

public class AuthorizationEncoder {
    private final ObjectMapper objectMapper;

    @Inject
    public AuthorizationEncoder(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public AuthenticatedWho decode(String token) {
        String decodedToken = urlDecode(token);

        Map<String, String> parameters = Splitter.on("&")
                .withKeyValueSeparator("=")
                .split(decodedToken)
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, entry.getKey()),
                        entry -> entry.getValue()
                ));

        return objectMapper.convertValue(parameters, AuthenticatedWho.class);
    }

    public String encode(AuthenticatedWho authenticatedWho) {
        String token = "";
        token += "ManyWhoTenantId=" +  authenticatedWho.getManyWhoTenantId() + "&";
        token += "ManyWhoUserId=" +  authenticatedWho.getManyWhoUserId() + "&";
        token += "ManyWhoToken=" +  authenticatedWho.getManyWhoToken() + "&";
        token += "DirectoryId=" +  authenticatedWho.getDirectoryId() + "&";
        token += "DirectoryName=" +  authenticatedWho.getDirectoryName() + "&";
        token += "RoleId=" +  authenticatedWho.getRoleId() + "&";
        token += "RoleName=" +  authenticatedWho.getRoleName() + "&";
        token += "PrimaryGroupId=" +  authenticatedWho.getPrimaryGroupId() + "&";
        token += "PrimaryGroupName=" +  authenticatedWho.getPrimaryGroupName() + "&";
        token += "Email=" +  authenticatedWho.getEmail() + "&";
        token += "IdentityProvider=" +  authenticatedWho.getIdentityProvider() + "&";
        token += "TenantName=" +  authenticatedWho.getTenantName() + "&";
        token += "Token=" +  authenticatedWho.getToken() + "&";
        token += "Username=" +  authenticatedWho.getUsername() + "&";
        token += "UserId=" +  authenticatedWho.getUserId() + "&";
        token += "FirstName=" +  authenticatedWho.getFirstName() + "&";
        token += "LastName=" +  authenticatedWho.getLastName();

        return urlEncode(token);
    }

    private static String urlDecode(String value) {
        try {
            return URLDecoder.decode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unable to decode the authorization token", e);
        }
    }

    private static String urlEncode(String value) {
        try {
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unable to encode the authorization token", e);
        }
    }
}
