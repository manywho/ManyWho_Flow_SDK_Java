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

        // If a port has been defined, use that
        if (redisConfiguration.getPort() > 0) {
            pool = new JedisPool(new JedisPoolConfig(), redisConfiguration.getEndpoint(), redisConfiguration.getPort());
        } else {
            pool = new JedisPool(new JedisPoolConfig(), redisConfiguration.getEndpoint());
        }

        // Initialize the maximum number of idle connections to Redis, instead of connecting lazily
        pool.addObjects(JedisPoolConfig.DEFAULT_MAX_IDLE);

        return pool;
    }

    @Override
    public void dispose(JedisPool jedisPool) {
        jedisPool.destroy();
    }
}
