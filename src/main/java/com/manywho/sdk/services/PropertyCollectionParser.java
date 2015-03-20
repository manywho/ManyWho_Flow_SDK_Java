package com.manywho.sdk.services;

import com.manywho.sdk.entities.run.elements.type.ObjectCollection;
import com.manywho.sdk.entities.run.elements.type.PropertyCollection;
import com.manywho.sdk.services.annotations.Property;
import org.apache.commons.collections4.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class PropertyCollectionParser {
    public static <T> T parse(PropertyCollection propertyCollection, Class<T> tClass) throws Exception {
        Set<Field> fields = BaseApplication.reflections.getFieldsAnnotatedWith(Property.class);

        T entity = tClass.newInstance();

        for (Field field : fields) {
            if (field.getDeclaringClass().equals(tClass)) {
                Property annotation = field.getAnnotation(Property.class);

                field.setAccessible(true);

                if (annotation.isObject()) {
                    if (annotation.isList()) {
                        setListField(field, annotation, propertyCollection, entity);
                    }

                    setObjectField(field, annotation, propertyCollection, entity);
                } else {
                    // It must be a scalar type
                    setScalarField(field, annotation, propertyCollection, entity);
                }
            }
        }

        validate(entity);

        return entity;
    }

    private static void validate(Object entity) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(entity);
        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

    private static void setListField(Field field, Property annotation, PropertyCollection properties, Object entity) throws Exception {
        // TODO
        throw new Exception("Not implemented yet");
    }

    private static void setObjectField(Field field, Property annotation, PropertyCollection properties, Object entity) throws Exception {
        ObjectCollection nestedPropertyCollection = properties.getObjectData(annotation.value());
        if (CollectionUtils.isNotEmpty(nestedPropertyCollection)) {
            field.set(entity, parse(nestedPropertyCollection.get(0).getProperties(), field.getType()));
        }
    }

    private static void setScalarField(Field field, Property annotation, PropertyCollection properties, Object entity) throws IllegalAccessException, ParseException {
        String propertyName = annotation.value();
        String propertyValue = properties.getContentValue(propertyName);

        Class fieldType = field.getType();
        if (fieldType.equals(long.class)) {
            field.set(entity, Long.parseLong(propertyValue));
        } else if (fieldType.equals(int.class)) {
            field.set(entity, Integer.parseInt(propertyValue));
        } else if (fieldType.equals(float.class)) {
            field.set(entity, Float.parseFloat(propertyValue));
        } else if (fieldType.equals(Date.class)) {
            // TODO: Check if this date format is sent the same from everywhere
            field.set(entity, new SimpleDateFormat("MM/dd/yyyy H:m:s a").parse(propertyValue));
        } else {
            field.set(entity, properties.getContentValue(propertyName));
        }
    }
}
