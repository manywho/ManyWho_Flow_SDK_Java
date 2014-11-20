package com.manywho.sdk.services.describe.types;

import com.manywho.sdk.entities.TypeElement;
import com.manywho.sdk.entities.TypeElementBindingCollection;
import com.manywho.sdk.entities.TypeElementPropertyCollection;

public abstract class AbstractType extends TypeElement implements Type {
    public abstract String getDeveloperName();

    @Override
    public String getDeveloperSummary() {
        return "The " + this.getDeveloperName() + " object structure";
    }

    public abstract TypeElementPropertyCollection getProperties();

    @Override
    public TypeElementBindingCollection getBindings() {
        return null;
    }
}
