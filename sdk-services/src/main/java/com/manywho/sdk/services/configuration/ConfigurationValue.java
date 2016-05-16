package com.manywho.sdk.services.configuration;

import com.manywho.sdk.api.ContentType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigurationValue {
    String name();
    ContentType contentType();
    boolean required() default true;
}
