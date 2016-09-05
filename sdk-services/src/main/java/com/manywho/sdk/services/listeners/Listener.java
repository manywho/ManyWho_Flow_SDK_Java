package com.manywho.sdk.services.listeners;

import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.types.Type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

public interface Listener<C extends Configuration, T extends Type> {

    void create(C configuration, T value);

    void createMultiple(C configuration, List<T> values);

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Metadata {
        String event();
    }
}
