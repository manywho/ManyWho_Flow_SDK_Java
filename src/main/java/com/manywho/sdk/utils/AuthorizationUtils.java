package com.manywho.sdk.utils;

import com.manywho.sdk.entities.security.AuthenticatedWho;
import com.manywho.sdk.enums.AuthenticatedWhoToken;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorizationUtils {
    public static AuthenticatedWho createPublicUserAuthenticatedWho(String tenantId) {
        return new AuthenticatedWho() {{
            setDirectoryId("UNAUTHENTICATED");
            setDirectoryName("UNKNOWN");
            setIdentityProvider("NONE");
            setEmail("admin@manywho.com");
            setManyWhoTenantId(tenantId);
            setManyWhoUserId("52DF1A90-3826-4508-B7C2-CDE8AA5B72CF");
            setTenantName("UNKNOWN");
            setToken("NONE");
            setUserId("PUBLIC_USER");
        }};
    }

    public static AuthenticatedWho deserialize(String token) {
        List<NameValuePair> pairs = URLEncodedUtils.parse(token, Charset.forName("UTF-8"));
        Map<String, String> parameters = new HashMap<>();
        for (NameValuePair nameValuePair : pairs) {
            parameters.put(nameValuePair.getName(), nameValuePair.getValue());
        }

        return new AuthenticatedWho() {{
            setDirectoryId(parameters.get(AuthenticatedWhoToken.DirectoryId.toString()));
            setDirectoryName(parameters.get(AuthenticatedWhoToken.DirectoryName.toString()));
            setEmail(parameters.get(AuthenticatedWhoToken.Email.toString()));
            setFirstName(parameters.get(AuthenticatedWhoToken.FirstName.toString()));
            setIdentityProvider(parameters.get(AuthenticatedWhoToken.IdentityProvider.toString()));
            setLastName(parameters.get(AuthenticatedWhoToken.LastName.toString()));
            setManyWhoTenantId(parameters.get(AuthenticatedWhoToken.ManyWhoTenantId.toString()));
            setManyWhoToken(parameters.get(AuthenticatedWhoToken.ManyWhoToken.toString()));
            setManyWhoUserId(parameters.get(AuthenticatedWhoToken.ManyWhoUserId.toString()));
            setTenantName(parameters.get(AuthenticatedWhoToken.TenantName.toString()));
            setToken(parameters.get(AuthenticatedWhoToken.Token.toString()));
            setUserId(parameters.get(AuthenticatedWhoToken.UserId.toString()));
            setUsername(parameters.get(AuthenticatedWhoToken.Username.toString()));
        }};
    }

    public static String serialize(AuthenticatedWho authenticatedWho) {
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
