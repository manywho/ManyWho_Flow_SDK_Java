package com.manywho.sdk.api.security;

import com.manywho.sdk.api.translate.Culture;

import java.util.UUID;

public class AuthenticatedWhoResult {
    private String userId;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
    private String directoryId;
    private String directoryName;
    private String tenantName;
    private UUID tenantId;
    private String identityProvider;
    private String token;
    private AuthenticationStatus status;
    private String statusMessage;
    private Culture culture;
    private String primaryGroupId;
    private String primaryGroupName;

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

    public UUID getTenantId() {
        return tenantId;
    }

    public void setTenantId(UUID tenantId) {
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

    public String getPrimaryGroupId() {
        return primaryGroupId;
    }

    public void setPrimaryGroupId(String primaryGroupId) {
        this.primaryGroupId = primaryGroupId;
    }

    public String getPrimaryGroupName() {
        return primaryGroupName;
    }

    public void setPrimaryGroupName(String primaryGroupName) {
        this.primaryGroupName = primaryGroupName;
    }

    public static AuthenticatedWhoResult createDeniedResult(String message) {
        AuthenticatedWhoResult result = new AuthenticatedWhoResult();
        result.setStatus(AuthenticationStatus.AccessDenied);
        result.setStatusMessage(message);

        return result;
    }

    public static AuthenticatedWhoResult createDeniedResult() {
        return createDeniedResult("Unable to login with the provided credentials");
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
