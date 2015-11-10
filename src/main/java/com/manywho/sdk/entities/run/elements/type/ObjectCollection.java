package com.manywho.sdk.entities.run.elements.type;

import java.util.ArrayList;
import java.util.Collections;

public class ObjectCollection extends ArrayList<MObject> {
    public ObjectCollection() {
    }

    public ObjectCollection(MObject... objects) {
        Collections.addAll(this, objects);
    }
}
