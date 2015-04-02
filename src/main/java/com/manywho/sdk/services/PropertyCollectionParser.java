package com.manywho.sdk.services;

import com.manywho.sdk.entities.ValueAware;
import com.manywho.sdk.services.annotations.Id;
import com.manywho.sdk.services.annotations.Property;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Set;

public class PropertyCollectionParser extends AbstractCollectionParser {
    @Override
    public <T> T parse(ValueAware properties, Class<T> tClass) throws Exception {
        return parse(properties, null, tClass);
    }

    @Override
    public <T> T parse(ValueAware properties, String id, Class<T> tClass) throws Exception {
        Set<Field> idFields = BaseApplication.reflections.getFieldsAnnotatedWith(Id.class);

        Set<Field> fields = BaseApplication.reflections.getFieldsAnnotatedWith(Property.class);

        T entity = tClass.newInstance();

        for (Field field : idFields) {
            if (field.getDeclaringClass().equals(tClass)) {
                if (StringUtils.isNotEmpty(id)) {
                    field.setAccessible(true);
                    field.set(entity, id);
                }
            }
        }

        for (Field field : fields) {
            if (field.getDeclaringClass().equals(tClass)) {
                Property annotation = field.getAnnotation(Property.class);

                field.setAccessible(true);

                if (annotation.isObject()) {
                    setObjectField(field, annotation.value(), properties, entity);
                } else if (annotation.isList()) {
                    setListField(field, annotation.value(), properties, entity);
                } else {
                    // It must be a scalar type
                    setScalarField(field, annotation.value(), properties, entity);
                }
            }
        }

        validate(entity);

        return entity;
    }
}
