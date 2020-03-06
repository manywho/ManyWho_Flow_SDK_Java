package com.manywho.sdk.api.run;

import com.manywho.sdk.api.run.elements.type.MObject;

import java.util.List;

public interface PropertyAware {
    String getContentValue();
    List<MObject> getObjectData();
}
