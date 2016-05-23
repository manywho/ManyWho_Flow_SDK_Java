package com.manywho.sdk.services.types;

import com.fasterxml.jackson.databind.util.ISO8601Utils;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.api.run.elements.type.Property;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TypeBuilder {
    private final TypeRepository typeRepository;

    @Inject
    public TypeBuilder(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<MObject> from(Type type) {
        return Lists.newArrayList(createSingle(type));
    }

    public List<MObject> from(Collection<? extends Type> types) {
        List<MObject> objects = Lists.newArrayList();

        if (types == null) {
            return objects;
        }

        for (Type type : types) {
            objects.add(createSingle(type));
        }

        return objects;
    }

    private MObject createSingle(Type type) {
        if (!type.getClass().isAnnotationPresent(Type.Element.class)) {
            throw new RuntimeException("The type " + type.getClass().getName() + " is not annotated with " + Type.Element.class.getName());
        }

        Type.Element annotation = type.getClass().getAnnotation(Type.Element.class);

        List<Field> typeProperties = typeRepository.getTypeProperties().stream()
                .filter(field -> field.getDeclaringClass().equals(type.getClass()))
                .collect(Collectors.toList());

        if (typeProperties.isEmpty()) {
            throw new RuntimeException("The type " + type.getClass().getName() + " does not contain any properties");
        }

        MObject object = new MObject(annotation.name());

        // Get the identifier field, if one exists
        Field identifierField = typeRepository.findTypeIdentifier(type.getClass());

        identifierField.setAccessible(true);

        try {
            Object identifierValue = identifierField.get(type);

            if (identifierValue == null) {
                throw new RuntimeException("The value of the identifier field on " + type.getClass().getName() + " cannot be null");
            }

            object.setExternalId(identifierValue.toString());
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to get the value of the identifier field on " + type.getClass().getName(), e);
        }

        List<Property> properties = typeProperties.stream()
                .map(property -> createProperty(type, property))
                .collect(Collectors.toList());

        object.setProperties(properties);

        return object;
    }

    private Property createProperty(Type type, Field field) {
        Type.Property annotation = field.getAnnotation(Type.Property.class);

        Property property = new Property(annotation.name());

        try {
            field.setAccessible(true);

            Object object = field.get(type);

            if (object == null) {
                return property;
            }

            switch (annotation.contentType()) {
                case Boolean:
                    property.setContentValue(convertBoolean(annotation.name(), object));
                    break;
                case Content:
                    property.setContentValue(convertContent(annotation.name(), object));
                    break;
                case DateTime:
                    property.setContentValue(convertDateTime(annotation.name(), object));
                    break;
                case Encrypted:
                    property.setContentValue(convertEncrypted(annotation.name(), object));
                    break;
                case List:
                    property.setObjectData(convertList(annotation.name(), object));
                    break;
                case Number:
                    property.setContentValue(convertNumber(annotation.name(), object));
                    break;
                case Object:
                    property.setObjectData(convertObject(annotation.name(), object));
                    break;
                case Password:
                    property.setContentValue(convertPassword(annotation.name(), object));
                    break;
                case String:
                    property.setContentValue(convertString(annotation.name(), object));
                    break;
                default:
                    throw new RuntimeException("Building " + annotation.contentType() + " properties is not yet supported in the Java SDK");
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to create the property " + annotation.name(), e);
        }

        return property;
    }

    private String convertBoolean(String property, Object object) {
        if (object instanceof Boolean) {
            return object.toString();
        }

        throw new TypePropertyInvalidException(property , "Boolean");
    }

    private String convertContent(String property, Object object) {
        if (object instanceof String) {
            return object.toString();
        }

        throw new TypePropertyInvalidException(property, "String");
    }

    private String convertDateTime(String property, Object object) {
        if (object instanceof TemporalAccessor) {
            return DateTimeFormatter.ISO_OFFSET_DATE_TIME.format((TemporalAccessor) object);
        } else if (object instanceof Date) {
            return ISO8601Utils.format((Date) object);
        }

        throw new TypePropertyInvalidException(property, "DateTime");
    }

    private String convertEncrypted(String property, Object object) {
        if (object instanceof String) {
            return object.toString();
        }

        throw new TypePropertyInvalidException(property, "String");
    }

    @SuppressWarnings("unchecked")
    private List<MObject> convertList(String property, Object object) {
        if (object instanceof Collection) {
            // TODO: Check that object is a collection of Type objects
            return from((Collection<? extends Type>) object);
        }

        throw new TypePropertyInvalidException(property, "Collection");
    }

    private String convertNumber(String property, Object object) {
        if (object instanceof Number) {
            return object.toString();
        }

        throw new TypePropertyInvalidException(property, "Number");
    }

    private List<MObject> convertObject(String property, Object object) {
        if (object instanceof Type) {
            return from((Type) object);
        }

        throw new TypePropertyInvalidException(property, "Object");
    }

    private String convertPassword(String property, Object object) {
        if (object instanceof String) {
            return object.toString();
        }

        throw new TypePropertyInvalidException(property, "String");
    }

    private String convertString(String property, Object object) {
        if (object instanceof String || object instanceof Enum) {
            return object.toString();
        }

        throw new TypePropertyInvalidException(property, "String or Enum");
    }
}
