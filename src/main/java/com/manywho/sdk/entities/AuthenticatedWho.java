package com.manywho.sdk.entities;

import javax.validation.constraints.NotNull;

public class AuthenticatedWho {
    private String manyWhoUserId;
    @NotNull
    private String manyWhoTenantId;
    private String manyWhoToken;
    private GeolocationInterface geolocation;
    private String userId;
    private String username;
    private String email;
    private String identityProvider;
    private String token;
    private String tenantName;
    private String directoryName;
    private String directoryId;
    private String firstName;
    private String lastName;

    public String getManyWhoUserId() {
        return manyWhoUserId;
    }

    public void setManyWhoUserId(String manyWhoUserId) {
        this.manyWhoUserId = manyWhoUserId;
    }

    public String getManyWhoTenantId() {
        return manyWhoTenantId;
    }

    public void setManyWhoTenantId(String manyWhoTenantId) {
        this.manyWhoTenantId = manyWhoTenantId;
    }

    public String getManyWhoToken() {
        return manyWhoToken;
    }

    public void setManyWhoToken(String manyWhoToken) {
        this.manyWhoToken = manyWhoToken;
    }

    public GeolocationInterface getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(GeolocationInterface geolocation) {
        this.geolocation = geolocation;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public String getDirectoryId() {
        return directoryId;
    }

    public void setDirectoryId(String directoryId) {
        this.directoryId = directoryId;
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
}
