package com.manywho.services.example.services.identity;

import com.manywho.sdk.api.security.AuthenticatedWhoResult;

import java.util.UUID;

public class AuthenticationService {
    public AuthenticatedWhoResult authenticateUser(String username) {
        AuthenticatedWhoResult result = new AuthenticatedWhoResult();
        result.setDirectoryId("Example");
        result.setDirectoryName("Example");
        result.setEmail("jonjo.mckay@manywho.com");
        result.setFirstName("Jonjo");
        result.setIdentityProvider("Example");
        result.setLastName("McKay");
        result.setStatus(AuthenticatedWhoResult.AuthenticationStatus.Authenticated);
        result.setTenantName("Example");
        result.setToken(UUID.randomUUID().toString());
        result.setUserId(username);
        result.setUsername(username);

        return result;
    }

    public boolean isValidUser(String username, String password) {
        if (username.equals("jonjomckay") && password.equals("password")) {
            return true;
        }

        return false;
    }
}
