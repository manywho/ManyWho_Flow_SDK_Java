package com.manywho.sdk.api.draw.content;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

public class Command {
    private String commandType;
    private Map<String, String> properties = Maps.newHashMap();

    public String getCommandType() {
        return commandType;
    }

    public void setCommandType(String commandType) {
        this.commandType = commandType;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = MoreObjects.firstNonNull(properties, new HashMap<String, String>());
    }
}
