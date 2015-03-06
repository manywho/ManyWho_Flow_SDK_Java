package com.manywho.sdk.entities.run;

import com.manywho.sdk.entities.run.elements.type.ObjectCollection;

import java.util.ArrayList;

public class EngineValueCollection extends ArrayList<EngineValue> {
    public String getContentValue(String name) {
        if (!this.isEmpty()) {
            return this.stream().filter(c -> c.getDeveloperName().equals(name)).findFirst().orElse(new EngineValue()).getContentValue();
        }

        return null;
    }

    public ObjectCollection getObjectData(String name) {
        if (!this.isEmpty()) {
            return this.stream().filter(o -> o.getDeveloperName().equals(name)).findFirst().orElse(new EngineValue()).getObjectData();
        }

        return null;
    }
}
