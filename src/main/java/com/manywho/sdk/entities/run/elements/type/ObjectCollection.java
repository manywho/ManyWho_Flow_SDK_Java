package com.manywho.sdk.entities.run.elements.type;

import java.util.ArrayList;
import java.util.Collections;

public class ObjectCollection extends ArrayList<Object> {
    public ObjectCollection() {
    }

    public ObjectCollection(Object... objects) {
        Collections.addAll(this, objects);
    }
}
