package com.manywho.sdk.services.values;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.run.PropertyAware;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.api.run.elements.type.Property;
import com.manywho.sdk.services.actions.Action;
import com.manywho.sdk.services.types.Type;
import com.manywho.sdk.services.types.TypeParser;
import com.manywho.sdk.services.types.TypePropertyMismatchException;
import com.manywho.sdk.services.types.TypeRepository;
import com.manywho.sdk.services.utils.Fields;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class ValueParser {
    private final static Logger LOGGER = LoggerFactory.getLogger(ValueParser.class);

    private final TypeRepository typeRepository;

    @Inject
    public ValueParser(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public <T extends Type> List<T> asList(List<MObject> objects, Class<T> type) {
        if (objects == null) {
            return Lists.newArrayList();
        }

        return objects.stream()
                .map(object -> asObject(object, type))
                .collect(Collectors.toList());
    }

    public List<Map<String, ValueProperty>> asMap(List<MObject> objects) {
        if (objects == null) {
            return Lists.newArrayList();
        }

        return objects.stream()
                .map(this::asMap)
                .collect(Collectors.toList());
    }

    public Map<String, ValueProperty> asMap(MObject object) {
        Map<String, ValueProperty> map = Maps.newHashMap();

        for (Property property : object.getProperties()) {
            ValueProperty valueProperty;

            if (property.getContentType().equals(ContentType.List) || property.getContentType().equals(ContentType.Object)) {
                valueProperty = new ValueProperty(property.getContentType(), asMap(property.getObjectData()));
            } else {
                valueProperty = new ValueProperty(property.getContentType(), property.getContentValue());
            }

            map.put(property.getDeveloperName(), valueProperty);
        }

        return map;
    }

    public <T extends Type> T asObject(List<MObject> objects, Class<T> type) {
        Type.Element typeAnnotation = type.getAnnotation(Type.Element.class);

        if (objects == null || objects.isEmpty()) {
            throw new RuntimeException("Unable to find an object to parse into " + typeAnnotation.name());
        }

        return asObject(objects.get(0), type);
    }

    public <T extends Type> T asObject(MObject object, Class<T> type) {
        try {
            T instance = type.newInstance();

            List<Field> typeFields = Fields.fromType(type);

            // Get the identifier field, if one exists
            boolean boundPropertiesExist = typeRepository.getTypeProperties().stream()
                    .filter(typeFields::contains)
                    .map(field -> field.getAnnotation(Type.Property.class))
                    .anyMatch(Type.Property::bound);

            if (boundPropertiesExist) {
                Field identifierField = typeRepository.findTypeIdentifier(type);

                AccessController.doPrivileged((PrivilegedAction) () -> {
                    identifierField.setAccessible(true);
                    return null;
                });

                if (object.getExternalId() == null || object.getExternalId().isEmpty()) {
                    identifierField.set(instance, null);
                } else if (String.class.isAssignableFrom(identifierField.getType())) {
                    identifierField.set(instance, object.getExternalId());
                } else if (UUID.class.isAssignableFrom(identifierField.getType())) {
                    identifierField.set(instance, UUID.fromString(object.getExternalId()));
                }
            }

            Map<String, Field> typeProperties = typeRepository.findTypeProperties(type);

            object.getProperties().stream()
                    .filter(property -> typeProperties.containsKey(property.getDeveloperName()))
                    .forEach(property -> {
                        Field field = typeProperties.get(property.getDeveloperName());

                        Type.Property annotation = field.getAnnotation(Type.Property.class);

                        populateObjectField(instance, field, annotation.contentType(), property);
                    });

            return instance;
        } catch (InstantiationException e) {
            throw new RuntimeException("The type " + type.getAnnotation(Type.Element.class).name() + " does not have a zero-argument constructor");
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean toBoolean(Field field, String value) {
        if (boolean.class.isAssignableFrom(field.getType()) || Boolean.class.isAssignableFrom(field.getType())) {
            return Boolean.valueOf(value);
        }

        throw new TypePropertyMismatchException(field, boolean.class, ContentType.Boolean);
    }

    public static String toContent(Field field, Object value) {
        return toString(field, value);
    }

    public static Object toDateTime(Field field, String value) {
        // TODO: Implement support for non-OffsetDateTime field types
        if (TemporalAccessor.class.isAssignableFrom(field.getType())) {
            return OffsetDateTime.parse(value);
        }

        OffsetDateTime dateTime = OffsetDateTime.parse(value);

        if (Timestamp.class.isAssignableFrom(field.getType())) {
            return Timestamp.from(dateTime.toInstant());
        }

        if (Time.class.isAssignableFrom(field.getType())) {
            return Time.from(dateTime.toInstant());
        }

        if (Date.class.isAssignableFrom(field.getType())) {
            return Date.from(dateTime.toInstant());
        }

        throw new TypePropertyMismatchException(field, TemporalAccessor.class.getName() + " or " + Date.class.getName(), ContentType.DateTime);
    }

    public static String toEncrypted(Field field, Object value) {
        return toString(field, value);
    }

    public static <T> T toEnum(Field field, String value, Class type) {
        try {
            Method method = type.getMethod("forValue", String.class);

            return (T) method.invoke(null, value);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("The enum \"" + type.getName() + "\" requires a method with the signature \"public static T forValue(String value)\"", e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to set the enum value: " + e.getMessage(), e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Unable to set the enum value: " + e.getTargetException().getMessage(), e);
        }
    }

    @SuppressWarnings("unchecked")
    private <T extends Type> Collection<T> toList(Field field, List<MObject> list) {
        Class<?> genericType = TypeParser.findGenericType(field.getGenericType(), 0);

        if (Type.class.isAssignableFrom(genericType)) {
            return asList(list, (Class<T>) genericType);
        }

        throw new TypePropertyMismatchException(field, Collection.class, ContentType.List);
    }

    public static Number toNumber(Field field, String value) {
        if (field.getType().equals(Double.class) || field.getType().equals(double.class)) {
            return Double.valueOf(value);
        }

        if (field.getType().equals(Float.class) || field.getType().equals(float.class)) {
            return Float.valueOf(value);
        }

        if (field.getType().equals(Integer.class) || field.getType().equals(int.class)) {
            return Integer.valueOf(value);
        }

        if (field.getType().equals(Long.class) || field.getType().equals(long.class)) {
            return Long.valueOf(value);
        }

        if (field.getType().equals(Short.class) || field.getType().equals(short.class)) {
            return Short.valueOf(value);
        }

        throw new TypePropertyMismatchException(field, Number.class, ContentType.Number);
    }

    @SuppressWarnings("unchecked")
    private <T extends Type> T toObject(Field field, List<MObject> objects) {
        if (Type.class.isAssignableFrom(field.getType())) {
            if (objects == null) {
                return null;
            }

            if (objects.isEmpty()) {
                if (field.isAnnotationPresent(Type.Property.class)) {
                    LOGGER.warn("No object was given for the {} type property", field.getAnnotation(Type.Property.class).name());
                } else if (field.isAnnotationPresent(Action.Input.class)) {
                    LOGGER.warn("No object was given for the {} action input", field.getAnnotation(Action.Input.class).name());
                } else if (field.isAnnotationPresent(Action.Output.class)) {
                    LOGGER.warn("No object was given for the {} action output", field.getAnnotation(Action.Output.class).name());
                } else {
                    LOGGER.warn("No object was given for the field {}", field.getName());
                }

                return null;
            }

            return asObject(objects.get(0), (Class<T>) field.getType());
        }

        throw new TypePropertyMismatchException(field, Type.class, ContentType.Object);
    }

    public static String toPassword(Field field, String value) {
        return toString(field, value);
    }

    public static String toString(Field field, Object value) {
        if (String.class.isAssignableFrom(field.getType())) {
            return (String) value;
        }

        return value.toString();
    }

    public void populateObjectField(Object object, Field field, ContentType contentType, PropertyAware property) {
        AccessController.doPrivileged((PrivilegedAction) () -> {
            field.setAccessible(true);
            return null;
        });

        // If we're being given an object or a list, skip population if the object data is null
        if (contentType.equals(ContentType.Object) || contentType.equals(ContentType.List)) {
           if (property.getObjectData() == null) {
               return;
           }
        } else if (property.getContentValue() == null) {
            // If we're being given scalar, skip population if the value is null
            return;
        }

        try {
            switch (contentType) {
                case Boolean:
                    field.set(object, toBoolean(field, property.getContentValue()));
                    break;
                case Content:
                    field.set(object, toContent(field, property.getContentValue()));
                    break;
                case DateTime:
                    if (Strings.isNullOrEmpty(property.getContentValue())) {
                        break;
                    }

                    field.set(object, toDateTime(field, property.getContentValue()));
                    break;
                case Encrypted:
                    field.set(object, toEncrypted(field, property.getContentValue()));
                    break;
                case List:
                    field.set(object, toList(field, property.getObjectData()));
                    break;
                case Number:
                    if (Strings.isNullOrEmpty(property.getContentValue())) {
                        break;
                    }

                    field.set(object, toNumber(field, property.getContentValue()));
                    break;
                case Object:
                    field.set(object, toObject(field, property.getObjectData()));
                    break;
                case Password:
                    field.set(object, toPassword(field, property.getContentValue()));
                    break;
                case String:
                    String value = toString(field, property.getContentValue());

                    if (!Strings.isNullOrEmpty(value)) {
                        // If the field is a UUID then parse the given value into one, otherwise use a plain String
                        if (field.getType().equals(UUID.class)) {
                            field.set(object, UUID.fromString(value));
                        } else if (field.getType().isEnum()) {
                            field.set(object, toEnum(field, value, field.getType()));
                        } else {
                            field.set(object, toString(field, property.getContentValue()));
                        }
                    }

                    break;
                default:
                    throw new RuntimeException("The content type " + contentType + " is not supported");
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
