package com.manywho.sdk.services.jaxrs.resolvers;

import com.google.inject.Injector;
import org.glassfish.jersey.server.validation.ValidationConfig;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorFactory;
import javax.ws.rs.ext.ContextResolver;

public class ValidationConfigurationContextResolver implements ContextResolver<ValidationConfig> {
    protected final Injector injector;

    @Inject
    public ValidationConfigurationContextResolver(Injector injector) {
        this.injector = injector;
    }

    @Override
    public ValidationConfig getContext(Class<?> aClass) {
        final ValidationConfig config = new ValidationConfig();

        config.constraintValidatorFactory(new ConstraintValidatorFactory() {
            @Override
            public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> aClass) {
                return injector.getInstance(aClass);
            }

            @Override
            public void releaseInstance(ConstraintValidator<?, ?> constraintValidator) {

            }
        });

        return config;
    }
}
