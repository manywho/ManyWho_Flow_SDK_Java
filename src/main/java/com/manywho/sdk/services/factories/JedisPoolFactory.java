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
        return new JedisPool(new JedisPoolConfig(), redisConfiguration.getEndpoint());
    }

    @Override
    public void dispose(JedisPool jedisPool) {
        jedisPool.destroy();
    }
}
