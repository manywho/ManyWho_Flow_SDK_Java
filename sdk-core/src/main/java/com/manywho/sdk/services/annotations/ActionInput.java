package com.manywho.sdk.services.annotations;

import com.manywho.sdk.enums.ContentType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionInput {
    String name();
    ContentType contentType();
    boolean required() default true;
    Class<?> referencedType() default void.class;
}
