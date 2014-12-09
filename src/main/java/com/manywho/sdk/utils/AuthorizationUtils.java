package com.manywho.sdk.utils;

import com.manywho.sdk.entities.security.AuthenticatedWho;
import com.manywho.sdk.enums.AuthenticatedWhoToken;

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
