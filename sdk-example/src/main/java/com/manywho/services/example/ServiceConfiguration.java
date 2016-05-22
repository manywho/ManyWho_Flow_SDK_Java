package com.manywho.services.example;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.configuration.Configuration;

public class ServiceConfiguration implements Configuration {
    @Configuration.Value(name = "Username", contentType = ContentType.String)
    private String username;

    @Configuration.Value(name = "Password", contentType = ContentType.Password)
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
