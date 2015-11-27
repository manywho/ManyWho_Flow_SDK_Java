package com.manywho.sdk.services.notifications;

import com.manywho.sdk.entities.security.AuthenticatedWho;

public interface Notifier {
    AuthenticatedWho getReceivingAuthenticatedWho();

    void setReceivingAuthenticatedWho(AuthenticatedWho receivingAuthenticatedWho);

    NotificationMessageCollection getNotificationMessages();

    void setNotificationMessages(NotificationMessageCollection notificationMessages);

    String getReason();

    void setReason(String reason);

    void addLogEntry(String entry);

    void addNotificationMessage(String mediaType, String message);

    void sendNotification();

    void sendNotification(AuthenticatedWho receivingAuthenticatedWho);

    void sendNotification(AuthenticatedWho receivingAuthenticatedWho, String reason, String mediaType, String message);
}
