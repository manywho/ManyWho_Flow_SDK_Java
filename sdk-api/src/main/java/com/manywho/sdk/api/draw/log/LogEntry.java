package com.manywho.sdk.api.draw.log;

import com.manywho.sdk.api.draw.elements.Element;
import org.joda.time.DateTime;

public class LogEntry extends Element {
    private DateTime timestamp;
    private String message;
    private String data;

    public DateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(DateTime timestamp) {
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
