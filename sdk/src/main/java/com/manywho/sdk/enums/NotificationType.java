package com.manywho.sdk.enums;

public enum NotificationType {
    Message("MESSAGE"),
    PasswordReset("PASSWORD_RESET"),
    TenantCreationEmailVerification("TENANT_CREATION_EMAIL_VERIFICATION"),
    DeleteAll("DELETE_ALL");

    private final String text;

    private NotificationType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
