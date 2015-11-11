package com.manywho.sdk.services.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Property {
    String value();
    boolean isObject() default false;
    boolean isList() default false;
    boolean isOutput() default true;
}
