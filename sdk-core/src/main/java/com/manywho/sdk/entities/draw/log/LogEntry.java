package com.manywho.sdk.entities.draw.log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.manywho.sdk.entities.draw.elements.Element;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LogEntry extends Element {
    private Date timestamp;
    private String message;
    private String data;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
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
