package com.manywho.sdk.services.values;

import com.manywho.sdk.api.ContentType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public @interface Value {

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Property {
        ContentType contentType();

        String name();

        boolean bound() default true;
    }
}
