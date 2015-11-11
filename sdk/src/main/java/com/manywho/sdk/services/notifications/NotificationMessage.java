package com.manywho.sdk.services.notifications;

public class NotificationMessage {
    private String mediaType;
    private String message;

    public NotificationMessage(String mediaType, String message) {
        this.mediaType = mediaType;
        this.message = message;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
