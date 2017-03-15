package com.manywho.sdk.services.types;

import com.manywho.sdk.api.ContentType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface Type {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Element {
        String name() default "";

        String summary() default "";
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Identifier {

        interface Custom {
            void setIdentifier(String identifier);
            String getIdentifier();
        }
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Property {
        ContentType contentType();

        String name();

        boolean bound() default true;
    }
}
