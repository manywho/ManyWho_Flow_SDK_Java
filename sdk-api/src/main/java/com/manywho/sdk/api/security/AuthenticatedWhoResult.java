package com.manywho.sdk.api.security;

import com.manywho.sdk.api.translate.Culture;

public class AuthenticatedWhoResult {
    private String userId;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String directoryId;
    private String directoryName;
    private String tenantName;
    private String tenantId;
    private String identityProvider;
    private String token;
    private AuthenticationStatus status;
    private String statusMessage;
    private Culture culture;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDirectoryId() {
        return directoryId;
    }

    public void setDirectoryId(String directoryId) {
        this.directoryId = directoryId;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getIdentityProvider() {
        return identityProvider;
    }

    public void setIdentityProvider(String identityProvider) {
        this.identityProvider = identityProvider;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public static AuthenticatedWhoResult createDeniedResult(String username) {
        AuthenticatedWhoResult result = createDeniedResult();
        result.setStatusMessage("The user with the username " + username + " could not be authenticated");

        return result;
    }

    public static AuthenticatedWhoResult createDeniedResult() {
        AuthenticatedWhoResult result = new AuthenticatedWhoResult();
        result.setStatus(AuthenticationStatus.AccessDenied);

        return result;
    }

    public enum AuthenticationStatus {
        AccessDenied("ACCESS_DENIED"),
        Authenticated("AUTHENTICATED");

        private final String text;

        AuthenticationStatus(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
