package com.manywho.sdk.entities.run.state;

import com.manywho.sdk.entities.ValueAware;
import com.manywho.sdk.entities.run.EngineValue;
import com.manywho.sdk.entities.run.elements.type.ObjectCollection;

import java.util.ArrayList;

public class StateValueCollection extends ArrayList<StateValue> implements ValueAware {
    @Override
    public String getContentValue(String name) {
        if (!this.isEmpty()) {
            return this.stream().filter(c -> c.getValueElementDeveloperName().equals(name)).findFirst().orElse(new StateValue()).getContentValue();
        }

        return null;
    }

    @Override
    public ObjectCollection getObjectData(String name) {
        if (!this.isEmpty()) {
            return this.stream().filter(o -> o.getValueElementDeveloperName().equals(name)).findFirst().orElse(new StateValue()).getObjectData();
        }

        return null;
    }
}
