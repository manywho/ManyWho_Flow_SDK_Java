package com.manywho.sdk.services;

import com.github.fge.lambdas.Throwing;
import com.manywho.sdk.entities.ContentValueAware;
import com.manywho.sdk.entities.ObjectDataAware;
import com.manywho.sdk.entities.ValueAware;
import com.manywho.sdk.entities.run.elements.type.MObject;
import com.manywho.sdk.entities.run.elements.type.ObjectCollection;
import com.manywho.sdk.services.annotations.TypeElement;
import com.manywho.sdk.services.types.TypeParser;
import com.manywho.sdk.services.types.TypeUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @deprecated As of version 1.18.0, this way of parsing is deprecated and annotating actions
 * with {@link com.manywho.sdk.services.annotations.Action} is the preferred way of parsing requests into beans
 */
@Deprecated
public abstract class AbstractCollectionParser {
    protected TypeParser typeParser;

    /**
     * @deprecated As of version 1.18.0, this way of parsing is deprecated and annotating actions
     * with {@link com.manywho.sdk.services.annotations.Action} is the preferred way of parsing requests into beans
     */
    @Deprecated
    public abstract <T> T parse(ValueAware properties, Class<T> tClass) throws Exception;

    /**
     * @deprecated As of version 1.18.0, this way of parsing is deprecated and annotating actions
     * with {@link com.manywho.sdk.services.annotations.Action} is the preferred way of parsing requests into beans
     */
    @Deprecated
    public abstract <T> T parse(ValueAware properties, String id, Class<T> tClass) throws Exception;

    protected void setListField(Field field, String annotationValue, ObjectDataAware properties, Object entity) throws Exception {
        ObjectCollection nestedPropertyCollection = properties.getObjectData(annotationValue);
        if (CollectionUtils.isNotEmpty(nestedPropertyCollection)) {
            // Find the generic type of the field
            Class<?> fieldClass = TypeUtils.getGenericType(field.getGenericType());

            // If the field is annotated with @TypeElement, parse the incoming data using TypeParser
            if (fieldClass.isAnnotationPresent(TypeElement.class)) {
                field.set(entity, typeParser.parseList(nestedPropertyCollection, fieldClass));
            } else {
                List<Object> list = nestedPropertyCollection.stream()
                        .map(Throwing.function(object -> parse(object.getProperties(), object.getExternalId(), fieldClass)))
                        .collect(Collectors.toList());

                field.set(entity, list);
            }
        }
    }

    protected void setObjectField(Field field, String annotationValue, ObjectDataAware properties, Object entity) throws Exception {
        ObjectCollection nestedPropertyCollection = properties.getObjectData(annotationValue);
        if (CollectionUtils.isNotEmpty(nestedPropertyCollection)) {
            MObject object = nestedPropertyCollection.get(0);

            // If the field is annotated with @TypeElement, parse the incoming data using TypeParser
            if (field.getType().isAnnotationPresent(TypeElement.class)) {
                field.set(entity, typeParser.parseObject(object, field.getType()));
            } else {
                field.set(entity, parse(object.getProperties(), object.getExternalId(), field.getType()));
            }
        }
    }

    protected void setScalarField(Field field, String annotationValue, ContentValueAware properties, Object entity) throws IllegalAccessException, ParseException {
        String propertyValue = properties.getContentValue(annotationValue);

        Class<?> fieldType = field.getType();
        if (fieldType.equals(long.class) || fieldType.equals(Long.class)) {
            field.set(entity, Long.parseLong(propertyValue));
        } else if (fieldType.equals(boolean.class) || fieldType.equals(Boolean.class)) {
            field.set(entity, parseBoolean(propertyValue));
        } else if (fieldType.equals(int.class) || fieldType.equals(Integer.class)) {
            field.set(entity, Integer.parseInt(propertyValue));
        } else if (fieldType.equals(float.class) || fieldType.equals(Float.class)) {
            field.set(entity, Float.parseFloat(propertyValue));
        } else if (fieldType.equals(DateTime.class)) {
            if (StringUtils.isNotEmpty(propertyValue)) {
                field.set(entity, DateTime.parse(propertyValue));
            }
        } else if (fieldType.equals(Date.class)) {
            // TODO: Check if this date format is sent the same from everywhere
            if (StringUtils.isNotEmpty(propertyValue)) {
                DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy H:m:s a");
                dateFormat.setLenient(true);

                try {
                    field.set(entity, dateFormat.parse(propertyValue));
                } catch (ParseException exception) {
                    field.set(entity, null);
                }
            }
        } else {
            field.set(entity, propertyValue);
        }
    }

    private boolean parseBoolean(String value) {
        return value.equalsIgnoreCase("1") || !value.equalsIgnoreCase("0") && Boolean.parseBoolean(value);
    }
}
