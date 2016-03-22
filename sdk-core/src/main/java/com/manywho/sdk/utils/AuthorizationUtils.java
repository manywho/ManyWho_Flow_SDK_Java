package com.manywho.sdk.utils;

import com.google.common.base.Charsets;
import com.manywho.sdk.entities.security.AuthenticatedWho;
import com.manywho.sdk.enums.AuthenticatedWhoToken;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AuthorizationUtils {
    public static AuthenticatedWho createPublicUserAuthenticatedWho(String tenantId) {
        AuthenticatedWho authenticatedWho = new AuthenticatedWho();
        authenticatedWho.setDirectoryId("UNAUTHENTICATED");
        authenticatedWho.setDirectoryName("UNKNOWN");
        authenticatedWho.setIdentityProvider("NONE");
        authenticatedWho.setEmail("admin@manywho.com");
        authenticatedWho.setManyWhoTenantId(tenantId);
        authenticatedWho.setManyWhoUserId("52DF1A90-3826-4508-B7C2-CDE8AA5B72CF");
        authenticatedWho.setTenantName("UNKNOWN");
        authenticatedWho.setToken("NONE");
        authenticatedWho.setUserId("PUBLIC_USER");

        return authenticatedWho;
    }

    public static AuthenticatedWho deserialize(String token) throws UnsupportedEncodingException {
        String decodedToken = URLDecoder.decode(token, "UTF-8");

        List<NameValuePair> pairs = URLEncodedUtils.parse(decodedToken, Charsets.UTF_8, '&');
        Map<String, String> parameters = new HashMap<>();
        for (NameValuePair nameValuePair : pairs) {
            parameters.put(nameValuePair.getName(), nameValuePair.getValue());
        }

        AuthenticatedWho authenticatedWho = new AuthenticatedWho();
        authenticatedWho.setDirectoryId(parameters.get(AuthenticatedWhoToken.DirectoryId.toString()));
        authenticatedWho.setDirectoryName(parameters.get(AuthenticatedWhoToken.DirectoryName.toString()));
        authenticatedWho.setEmail(parameters.get(AuthenticatedWhoToken.Email.toString()));
        authenticatedWho.setFirstName(parameters.get(AuthenticatedWhoToken.FirstName.toString()));
        authenticatedWho.setIdentityProvider(parameters.get(AuthenticatedWhoToken.IdentityProvider.toString()));
        authenticatedWho.setLastName(parameters.get(AuthenticatedWhoToken.LastName.toString()));
        authenticatedWho.setManyWhoTenantId(parameters.get(AuthenticatedWhoToken.ManyWhoTenantId.toString()));
        authenticatedWho.setManyWhoToken(parameters.get(AuthenticatedWhoToken.ManyWhoToken.toString()));
        authenticatedWho.setManyWhoUserId(parameters.get(AuthenticatedWhoToken.ManyWhoUserId.toString()));
        authenticatedWho.setTenantName(parameters.get(AuthenticatedWhoToken.TenantName.toString()));
        authenticatedWho.setToken(parameters.get(AuthenticatedWhoToken.Token.toString()));
        authenticatedWho.setUserId(parameters.get(AuthenticatedWhoToken.UserId.toString()));
        authenticatedWho.setUsername(parameters.get(AuthenticatedWhoToken.Username.toString()));

        return authenticatedWho;
    }

    public static String serialize(AuthenticatedWho authenticatedWho) throws Exception {
        if (authenticatedWho == null) {
            throw new Exception("AuthenticatedWho cannot be null");
        }

        String token = "";

        token += AuthenticatedWhoToken.ManyWhoTenantId + "=" + authenticatedWho.getManyWhoTenantId() + "&";
        token += AuthenticatedWhoToken.ManyWhoUserId + "=" + authenticatedWho.getManyWhoUserId() + "&";
        token += AuthenticatedWhoToken.ManyWhoToken + "=" + authenticatedWho.getManyWhoToken() + "&";
        token += AuthenticatedWhoToken.DirectoryId + "=" + authenticatedWho.getDirectoryId() + "&";
        token += AuthenticatedWhoToken.DirectoryName + "=" + authenticatedWho.getDirectoryName() + "&";
        token += AuthenticatedWhoToken.Email + "=" + authenticatedWho.getEmail() + "&";
        token += AuthenticatedWhoToken.IdentityProvider + "=" + authenticatedWho.getIdentityProvider() + "&";
        token += AuthenticatedWhoToken.TenantName + "=" + authenticatedWho.getTenantName() + "&";
        token += AuthenticatedWhoToken.Token + "=" + authenticatedWho.getToken() + "&";
        token += AuthenticatedWhoToken.Username + "=" + authenticatedWho.getUsername() + "&";
        token += AuthenticatedWhoToken.UserId + "=" + authenticatedWho.getUserId() + "&";
        token += AuthenticatedWhoToken.FirstName + "=" + authenticatedWho.getFirstName() + "&";
        token += AuthenticatedWhoToken.LastName + "=" + authenticatedWho.getLastName();

        // Encode the token ready for http
        return token;
    }
}
