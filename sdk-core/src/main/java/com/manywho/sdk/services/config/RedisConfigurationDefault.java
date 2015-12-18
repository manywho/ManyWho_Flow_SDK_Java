package com.manywho.sdk.services.config;

import javax.inject.Inject;

public class RedisConfigurationDefault implements RedisConfiguration {

    private ServiceConfiguration configuration;

    @Inject
    public RedisConfigurationDefault(ServiceConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public String getEndpoint() {
        return configuration.get("redis.url");
    }

    @Override
    public int getPort() {
        if (configuration.has("redis.port")) {
            return Integer.parseInt(configuration.get("redis.port"));
        }

        return 6379;
    }
}
