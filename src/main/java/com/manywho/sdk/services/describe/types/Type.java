package com.manywho.sdk.services.describe.types;

import com.manywho.sdk.entities.draw.elements.type.TypeElementBindingCollection;
import com.manywho.sdk.entities.draw.elements.type.TypeElementPropertyCollection;

public interface Type {
    public String getDeveloperName();

    public String getDeveloperSummary();

    public TypeElementBindingCollection getBindings();

    public TypeElementPropertyCollection getProperties();
}
