package com.manywho.services.example;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.configuration.ConfigurationValue;

public class ApplicationConfiguration {
    @ConfigurationValue(name = "Username", contentType = ContentType.String)
    private String username;

    @ConfigurationValue(name = "Password", contentType = ContentType.Password)
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
