package com.manywho.sdk.services.unit.entities;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.configuration.Configuration;

public class TestConfigurationValues {
    @Configuration.Value(name = "Value One", contentType = ContentType.String)
    private String valueOne;

    @Configuration.Value(name = "Value Two", contentType = ContentType.String, required = false)
    private String valueTwo;
}
