package com.manywho.sdk.services.describe.types;

import com.manywho.sdk.entities.TypeElementBindingCollection;
import com.manywho.sdk.entities.TypeElementPropertyCollection;

public interface Type {
    public String getDeveloperName();

    public String getDeveloperSummary();

    public TypeElementBindingCollection getBindings();

    public TypeElementPropertyCollection getProperties();
}
