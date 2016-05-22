package com.manywho.sdk.services.configuration;

import com.manywho.sdk.api.ContentType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface Configuration {
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Value {
        String name();
        ContentType contentType();
        boolean required() default true;
    }
}
