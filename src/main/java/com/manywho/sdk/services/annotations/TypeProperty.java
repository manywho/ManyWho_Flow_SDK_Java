package com.manywho.sdk.services.annotations;

import com.manywho.sdk.enums.ContentType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeProperty {
    String name();
    ContentType contentType();
    boolean bound() default true;
}
