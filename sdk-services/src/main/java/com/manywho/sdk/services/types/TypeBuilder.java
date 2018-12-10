package com.manywho.sdk.services.types;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.api.run.elements.type.Property;
import com.manywho.sdk.services.utils.Fields;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.stream.Collectors;

import static org.reflections.ReflectionUtils.*;

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
        if (type == null) {
            return null;
        }

        if (!type.getClass().isAnnotationPresent(Type.Element.class)) {
            throw new RuntimeException("The type " + type.getClass().getName() + " is not annotated with " + Type.Element.class.getName());
        }

        Type.Element annotation = type.getClass().getAnnotation(Type.Element.class);

        List<Field> typeFields = Fields.fromType(type.getClass());

        List<Field> typeProperties = typeRepository.getTypeProperties().stream()
                .filter(typeFields::contains)
                .collect(Collectors.toList());

        if (typeProperties.isEmpty()) {
            throw new RuntimeException("The type " + type.getClass().getName() + " does not contain any properties");
        }

        MObject object = new MObject(annotation.name());

        // Get the identifier field, if one exists
        boolean boundPropertiesExist = typeRepository.getTypeProperties().stream()
                .filter(typeFields::contains)
                .map(field -> field.getAnnotation(Type.Property.class))
                .anyMatch(Type.Property::bound);

        if (boundPropertiesExist) {
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
        }

        List<Property> properties = typeProperties.stream()
                .map(property -> createProperty(type, property))
                .collect(Collectors.toList());

        object.setProperties(properties);

        return object;
    }

    private Property createProperty(Type type, Field field) {
        Type.Property annotation = field.getAnnotation(Type.Property.class);

        String propertyDeveloperName = annotation.columnName();

        // If we're not given a column name for the property, use the developer name
        if (Strings.isNullOrEmpty(annotation.columnName())) {
            propertyDeveloperName = annotation.name();
        }

        Property property = new Property(propertyDeveloperName);
        property.setContentType(annotation.contentType());

        try {
            field.setAccessible(true);

            Object object = field.get(type);

            // If no value was found for the field, we fallback to a bean getter
            if (object == null) {
                Set<Method> methods = getAllMethods(type.getClass(),
                        withModifier(Modifier.PUBLIC), withPrefix("get"), withAnnotation(annotation));

                if (methods.iterator().hasNext()) {
                    Method method = methods.iterator().next();

                    if (method == null) {
                        throw new RuntimeException("No getter could be found for " + field.getName());
                    }

                    try {
                        object = method.invoke(null);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException("Unable to invoke the getter for " + field.getName());
                    }
                }
            }

            // If no value was found for either the field or from the getter, we just return the property as-is
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
        TemporalAccessor temporalAccessor = null;

        if (object instanceof LocalDateTime) {
            temporalAccessor = OffsetDateTime.of((LocalDateTime) object, ZoneOffset.UTC);
        } else if (object instanceof TemporalAccessor) {
            temporalAccessor = (TemporalAccessor) object;
        } else if (object instanceof Date) {
            temporalAccessor = OffsetDateTime.ofInstant(((Date) object).toInstant(), ZoneOffset.UTC);
        }

        if (temporalAccessor == null) {
            throw new TypePropertyInvalidException(property, "DateTime");
        }

        return DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(temporalAccessor);
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
        // We (probably) never want to return passwords - open an issue if this is a problem!
        return null;
    }

    private String convertString(String property, Object object) {
        if (object instanceof String || object instanceof Enum || object instanceof UUID) {
            return object.toString();
        }

        throw new TypePropertyInvalidException(property, "String, UUID or an enum");
    }
}
