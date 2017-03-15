package com.manywho.sdk.services.actions;

import com.manywho.sdk.api.ContentType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface Action {
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Metadata {
        String name() default "";

        String summary() default "";

        String uri();
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Input {
        ContentType contentType();

        String name();

        boolean required() default true;
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Output {
        ContentType contentType();

        String name();

        boolean required() default true;
    }
}
