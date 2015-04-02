package com.manywho.sdk.entities;

import com.manywho.sdk.entities.run.elements.type.ObjectCollection;

public interface ObjectDataAware {
    ObjectCollection getObjectData(String name);
}
