package com.manywho.sdk.services.jaxrs.resolvers;

import org.glassfish.jersey.server.validation.ValidationConfig;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorFactory;
import javax.ws.rs.ext.ContextResolver;

public class ValidationConfigurationContextResolver implements ContextResolver<ValidationConfig> {
    @Override
    public ValidationConfig getContext(Class<?> aClass) {
        final ValidationConfig config = new ValidationConfig();

        config.constraintValidatorFactory(new ConstraintValidatorFactory() {
            @Override
            public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> aClass) {
                try {
                    return aClass.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException("Unable to create a new instance of " + aClass.getCanonicalName(), e);
                }
            }

            @Override
            public void releaseInstance(ConstraintValidator<?, ?> constraintValidator) {

            }
        });

        return config;
    }
}
