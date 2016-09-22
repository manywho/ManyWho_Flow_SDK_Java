package com.manywho.sdk.services.unit.entities;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.configuration.Configuration;

public class TestConfigurationSettings {
    @Configuration.Setting(name = "Value One", contentType = ContentType.String)
    private String valueOne;

    @Configuration.Setting(name = "Value Two", contentType = ContentType.String, required = false)
    private String valueTwo;
}
