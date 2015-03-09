package com.manywho.sdk.services;

import com.manywho.sdk.entities.run.EngineValueCollection;
import com.manywho.sdk.services.annotations.ConfigurationValue;

import java.lang.IllegalAccessException;
import java.lang.String;
import java.lang.reflect.Field;
import java.util.Set;

public abstract class AbstractConfigurationValues {
    public AbstractConfigurationValues populate(EngineValueCollection configurationValues) throws IllegalAccessException {
        Set<Field> fields = BaseApplication.reflections.getFieldsAnnotatedWith(ConfigurationValue.class);

        for (Field field : fields) {
            if (field.getDeclaringClass().equals(this.getClass())) {
                String valueName = field.getAnnotation(ConfigurationValue.class).value();

                field.setAccessible(true);
                field.set(this, configurationValues.getContentValue(valueName));
            }
        }

        return this;
    }
}
