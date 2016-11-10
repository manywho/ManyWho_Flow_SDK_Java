package com.manywho.sdk.services.factories;

import com.manywho.sdk.services.config.RedisConfiguration;
import org.glassfish.hk2.api.Factory;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.URI;
import java.net.URISyntaxException;

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
            String endpoint = redisConfiguration.getEndpoint();

            // If the endpoint doesn't have a scheme, then add the redis:// scheme (feels hacky)
            if (!endpoint.contains("://")) {
                endpoint = "redis://" + endpoint;
            }

            try {
                pool = new JedisPool(new JedisPoolConfig(), new URI(endpoint));
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
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
