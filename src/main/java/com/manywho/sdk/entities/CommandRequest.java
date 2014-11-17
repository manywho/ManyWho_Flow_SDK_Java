package com.manywho.sdk.entities;

import java.util.HashMap;

public class CommandRequest {
    private String commandType;
    private HashMap<String, String> properties;

    public String getCommandType() {
        return commandType;
    }

    public void setCommandType(String commandType) {
        this.commandType = commandType;
    }

    public HashMap<String, String> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, String> properties) {
        this.properties = properties;
    }
}
