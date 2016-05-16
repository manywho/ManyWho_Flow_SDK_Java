package com.manywho.sdk.api.draw.log;

import com.manywho.sdk.api.draw.elements.Element;

import java.time.LocalDateTime;

public class LogEntry extends Element {
    private LocalDateTime timestamp;
    private String message;
    private String data;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
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
