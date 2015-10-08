package com.manywho.sdk.services;

import com.manywho.sdk.entities.run.elements.type.Object;
import com.manywho.sdk.entities.run.elements.type.ObjectCollection;
import com.manywho.sdk.entities.run.elements.type.PropertyCollection;
import com.manywho.sdk.services.annotations.Id;
import com.manywho.sdk.services.annotations.Property;
import com.manywho.sdk.services.annotations.Type;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class ObjectBuilder {
    public <T> Object build(java.lang.Object object, Class<T> tClass) throws Exception {
        if (object == null) {
            return null;
        }

        T mappedEntity = new ModelMapper().map(object, tClass);

        PropertyCollection properties = new PropertyCollection();

        String id = null;

        for (Field field : mappedEntity.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class)) {
                id = String.valueOf(getFieldValue(field, mappedEntity));
            }

            if (field.isAnnotationPresent(Property.class)) {
                Property property = field.getAnnotation(Property.class);

                if (property.isOutput()) {
                    if (property.isObject()) {
                        properties.add(buildObjectProperty(field, property.value(), mappedEntity));
                    } else if (property.isList()) {
                        properties.add(buildListProperty(field, property.value(), mappedEntity));
                    } else {
                        properties.add(buildScalarProperty(field, property.value(), mappedEntity));
                    }
                }
            }
        }

        if (id == null) {
            throw new Exception(String.format("The entity %s does not have an @Id annotation denoting the External ID", mappedEntity.getClass().getName()));
        }

        if (!mappedEntity.getClass().isAnnotationPresent(Type.class)) {
            throw new Exception(String.format("The entity %s does not have a @Type annotation", mappedEntity.getClass().getName()));
        }

        return buildObject(mappedEntity.getClass().getAnnotation(Type.class).value(), id, properties);
    }

    private java.lang.Object getFieldValue(Field field, java.lang.Object entity) {
        field.setAccessible(true);

        try {
            return field.get(entity);
        } catch (Exception exception) {
            return null;
        }
    }

    private Object buildObject(String developerName, String externalId, PropertyCollection properties) {
        return new Object() {{
            setDeveloperName(developerName);
            setExternalId(externalId);
            setProperties(properties);
        }};
    }

    private com.manywho.sdk.entities.run.elements.type.Property buildObjectProperty(Field field, String developerName, java.lang.Object entity) throws Exception {
        return new com.manywho.sdk.entities.run.elements.type.Property(developerName, build(getFieldValue(field, entity), field.getType()));
    }

    private com.manywho.sdk.entities.run.elements.type.Property buildListProperty(Field field, String developerName, java.lang.Object entity) throws Exception {
        java.lang.Object fieldValue = getFieldValue(field, entity);

        ObjectCollection objectCollection = new ObjectCollection();

        if (fieldValue != null) {
            for (java.lang.Object item : (Collection) fieldValue) {
                objectCollection.add(build(item, item.getClass()));
            }
        }

        return new com.manywho.sdk.entities.run.elements.type.Property(developerName, objectCollection);
    }

    private com.manywho.sdk.entities.run.elements.type.Property buildScalarProperty(Field field, String developerName, java.lang.Object entity) {
        java.lang.Object value = getFieldValue(field, entity);

        if (value instanceof Date) {
            value = new SimpleDateFormat("MM/dd/yyyy H:m:s a").format(value);
        }
        
        return new com.manywho.sdk.entities.run.elements.type.Property(developerName, value);
    }
}
