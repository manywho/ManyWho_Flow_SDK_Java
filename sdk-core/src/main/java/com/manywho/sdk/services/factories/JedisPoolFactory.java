package com.manywho.sdk.services.factories;

import com.manywho.sdk.services.config.RedisConfiguration;
import org.glassfish.hk2.api.Factory;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class JedisPoolFactory implements Factory<JedisPool> {
    @Inject
    private RedisConfiguration redisConfiguration;

    @Override
    public JedisPool provide() {
        JedisPool pool;
        int port = 6379;

        // If a port has been defined, use that
        if (redisConfiguration.getPort() > 0) {
            port = redisConfiguration.getPort();
        }

        pool = new JedisPool(new JedisPoolConfig(), redisConfiguration.getEndpoint(), port);

        // Initialize the maximum number of idle connections to Redis, instead of connecting lazily
        pool.addObjects(JedisPoolConfig.DEFAULT_MAX_IDLE);

        return pool;
    }

    @Override
    public void dispose(JedisPool jedisPool) {
        jedisPool.destroy();
    }
}
