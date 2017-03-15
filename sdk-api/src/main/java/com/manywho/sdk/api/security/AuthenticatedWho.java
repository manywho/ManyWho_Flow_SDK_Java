package com.manywho.sdk.api.security;

import com.manywho.sdk.api.run.state.Geolocation;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class AuthenticatedWho {
    private UUID manyWhoUserId;
    @NotNull
    private UUID manyWhoTenantId;
    private String manyWhoToken;
    private Geolocation geolocation;
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
    private String roleName;
    private String roleId;
    private String primaryGroupName;
    private String primaryGroupId;

    public UUID getManyWhoUserId() {
        return manyWhoUserId;
    }

    public void setManyWhoUserId(UUID manyWhoUserId) {
        this.manyWhoUserId = manyWhoUserId;
    }

    public UUID getManyWhoTenantId() {
        return manyWhoTenantId;
    }

    public void setManyWhoTenantId(UUID manyWhoTenantId) {
        this.manyWhoTenantId = manyWhoTenantId;
    }

    public String getManyWhoToken() {
        return manyWhoToken;
    }

    public void setManyWhoToken(String manyWhoToken) {
        this.manyWhoToken = manyWhoToken;
    }

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Geolocation geolocation) {
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPrimaryGroupName() {
        return primaryGroupName;
    }

    public void setPrimaryGroupName(String primaryGroupName) {
        this.primaryGroupName = primaryGroupName;
    }

    public String getPrimaryGroupId() {
        return primaryGroupId;
    }

    public void setPrimaryGroupId(String primaryGroupId) {
        this.primaryGroupId = primaryGroupId;
    }

    public static AuthenticatedWho createPublicUser(UUID tenant) {
        AuthenticatedWho authenticatedWho = new AuthenticatedWho();
        authenticatedWho.setDirectoryId("UNAUTHENTICATED");
        authenticatedWho.setDirectoryName("UNKNOWN");
        authenticatedWho.setIdentityProvider("NONE");
        authenticatedWho.setEmail("admin@manywho.com");
        authenticatedWho.setManyWhoTenantId(tenant);
        authenticatedWho.setManyWhoUserId(UUID.fromString("52DF1A90-3826-4508-B7C2-CDE8AA5B72CF"));
        authenticatedWho.setTenantName("UNKNOWN");
        authenticatedWho.setToken("NONE");
        authenticatedWho.setUserId("PUBLIC_USER");

        return authenticatedWho;
    }
}
