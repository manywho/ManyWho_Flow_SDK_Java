package com.manywho.sdk.services.factories;

import com.manywho.sdk.services.config.DatabaseConfiguration;
import org.glassfish.hk2.api.Factory;
import org.sql2o.Sql2o;
import org.sql2o.converters.UUIDConverter;
import org.sql2o.quirks.PostgresQuirks;

import javax.inject.Inject;
import java.util.UUID;

public class Sql2oFactory implements Factory<Sql2o> {

    @Inject
    private DatabaseConfiguration configuration;

    @Override
    public Sql2o provide() {
        return new Sql2o(configuration.getUrl(), configuration.getUsername(), configuration.getPassword(), new PostgresQuirks() {
            {
                converters.put(UUID.class, new UUIDConverter());
            }
        });
    }

    @Override
    public void dispose(Sql2o instance) {
        instance.withConnection((connection, o) -> {
            connection.close();
        });
    }
}
