package com.manywho.sdk.services.notifications;

import com.manywho.sdk.entities.security.AuthenticatedWho;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNotifier implements Notifier {
    protected AuthenticatedWho receivingAuthenticatedWho;
    protected NotificationMessageCollection notificationMessages;
    protected String reason;
    protected List<String> logEntries = new ArrayList<>();

    @Override
    public AuthenticatedWho getReceivingAuthenticatedWho() {
        return this.receivingAuthenticatedWho;
    }

    @Override
    public void setReceivingAuthenticatedWho(AuthenticatedWho receivingAuthenticatedWho) {
        this.receivingAuthenticatedWho = receivingAuthenticatedWho;
    }

    @Override
    public NotificationMessageCollection getNotificationMessages() {
        return this.notificationMessages;
    }

    @Override
    public void setNotificationMessages(NotificationMessageCollection notificationMessages) {
        this.notificationMessages = notificationMessages;
    }

    @Override
    public String getReason() {
        return this.reason;
    }

    @Override
    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public void addLogEntry(String logEntry) {
        this.logEntries.add(logEntry);
    }

    @Override
    public void addNotificationMessage(String mediaType, String message) {
        this.notificationMessages.add(new NotificationMessage(mediaType, message));
    }
}
