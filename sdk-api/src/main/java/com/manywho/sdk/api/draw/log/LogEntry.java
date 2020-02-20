package com.manywho.sdk.api.draw.log;

import com.manywho.sdk.api.draw.elements.Element;

import java.time.OffsetDateTime;

public class LogEntry extends Element {
    private OffsetDateTime timestamp;
    private String message;
    private String data;

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
