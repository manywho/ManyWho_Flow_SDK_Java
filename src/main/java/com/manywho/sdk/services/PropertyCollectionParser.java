package com.manywho.sdk.services;

import com.manywho.sdk.entities.run.elements.type.PropertyCollection;
import com.manywho.sdk.services.annotations.Property;

import java.lang.reflect.Field;
import java.util.Set;

public class PropertyCollectionParser {
    public static <T> T parse(PropertyCollection propertyCollection, Class<T> tClass) throws IllegalAccessException, InstantiationException {
        Set<Field> fields = BaseApplication.reflections.getFieldsAnnotatedWith(Property.class);

        T entity = tClass.newInstance();

        for (Field field : fields) {
            String propertyName = field.getAnnotation(Property.class).value();

            field.setAccessible(true);
            field.set(entity, propertyCollection.getContentValue(propertyName));
        }

        return entity;
    }
}
