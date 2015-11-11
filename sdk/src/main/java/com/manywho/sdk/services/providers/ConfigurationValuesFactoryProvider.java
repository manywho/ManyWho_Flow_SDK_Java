package com.manywho.sdk.services.providers;

import com.manywho.sdk.services.factories.ConfigurationValuesFactory;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.internal.inject.AbstractValueFactoryProvider;
import org.glassfish.jersey.server.internal.inject.MultivaluedParameterExtractorProvider;
import org.glassfish.jersey.server.model.Parameter;

import javax.inject.Inject;
import javax.ws.rs.ext.Provider;
import java.lang.Override;

@Provider
public class ConfigurationValuesFactoryProvider extends AbstractValueFactoryProvider {
    @Inject
    private ConfigurationValuesFactory configurationValuesFactory;

    @Inject
    public ConfigurationValuesFactoryProvider(MultivaluedParameterExtractorProvider mpep, ServiceLocator locator) {
        super(mpep, locator, Parameter.Source.UNKNOWN);
    }

    @Override
    protected Factory<?> createValueFactory(Parameter parameter) {
        return configurationValuesFactory.setClassType(parameter.getRawType());
    }
}
