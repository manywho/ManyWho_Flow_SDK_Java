package com.manywho.sdk.entities.run;

import java.util.ArrayList;

public class EngineValueCollection extends ArrayList<EngineValue> {
    public String getContentValue(String name) {
        return this.stream().filter(c -> c.getDeveloperName().equals(name)).findFirst().orElse(new EngineValue()).getContentValue();
    }
}
