package com.manywho.sdk.enums;

public enum AuthenticatedWhoToken {
    ManyWhoTenantId("ManyWhoTenantId"),
    ManyWhoUserId("ManyWhoUserId"),
    ManyWhoToken("ManyWhoToken"),
    DirectoryId("DirectoryId"),
    DirectoryName("DirectoryName"),
    Email("Email"),
    IdentityProvider("IdentityProvider"),
    TenantName("TenantName"),
    Token("Token"),
    UserId("UserId"),
    Username("Username"),
    FirstName("FirstName"),
    LastName("LastName");

    private final String text;

    private AuthenticatedWhoToken(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
