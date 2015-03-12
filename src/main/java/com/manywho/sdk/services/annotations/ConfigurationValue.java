package com.manywho.sdk.services.annotations;

import java.lang.String;import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigurationValue {
    String value();
}
