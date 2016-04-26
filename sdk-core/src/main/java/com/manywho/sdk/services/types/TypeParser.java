package com.manywho.sdk.services.types;

import com.github.fge.lambdas.Throwing;
import com.manywho.sdk.entities.run.elements.type.MObject;
import com.manywho.sdk.entities.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.entities.run.elements.type.ObjectDataTypePropertyCollection;
import com.manywho.sdk.entities.run.elements.type.Property;
import com.manywho.sdk.enums.ContentType;
import com.manywho.sdk.services.annotations.Id;
import com.manywho.sdk.services.annotations.TypeElement;
import com.manywho.sdk.services.annotations.TypeProperty;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.reflections.Reflections;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TypeParser {
    private Reflections reflections;

    @Inject
    public TypeParser(Reflections reflections) {
        this.reflections = reflections;
    }

    public <T> List<T> parseList(ObjectDataRequest objectDataRequest, Class<T> tClass) throws Exception {
        return this.parseObjectDataRequest(objectDataRequest, tClass)
                .collect(Collectors.toList());
    }

    public <T> List<T> parseList(List<MObject> objects, Class<T> tClass) throws Exception {
        return objects.stream().map(Throwing.function(object -> this.parseObject(object, tClass)))
                .collect(Collectors.toList());
    }

    public <T> T parseObject(MObject object, Class<T> tClass) throws Exception {
        return this.parseObjectData(object, tClass);
    }

    public <T> T parseObject(ObjectDataRequest objectDataRequest, Class<T> tClass) throws Exception {
        Optional<T> typeObjectOptional = this.parseObjectDataRequest(objectDataRequest, tClass)
                .limit(1)
                .findFirst();

        if (typeObjectOptional.isPresent()) {
            return typeObjectOptional.get();
        }

        return null;
    }

    private <T> Stream<T> parseObjectDataRequest(ObjectDataRequest objectDataRequest, Class<T> tClass) throws Exception {
        // Assert the type that was passed in exists
        assertTypeElementExists(reflections, objectDataRequest.getObjectDataType().getDeveloperName());

        ObjectDataTypePropertyCollection incomingProperties = objectDataRequest.getObjectDataType().getProperties();

        // Find all the TypeProperties that are set to "bound" and are in the incoming object data
        Set<TypePropertyFieldTuple> boundProperties = this.createTypePropertyTuples(tClass)
                .filter(tuple -> tuple.getTypeProperty().bound())
                .filter(tuple -> incomingProperties.stream().anyMatch(p -> p.getDeveloperName().equals(tuple.getTypeProperty().name())))
                .collect(Collectors.toSet());

        return objectDataRequest.getObjectData().stream()
                .map(Throwing.function(object -> createTypeObjectFromObject(object, boundProperties, tClass)));
    }

    private <T> T parseObjectData(MObject object, Class<T> tClass) throws Exception {
        // Assert the type that was passed in exists
        assertTypeElementExists(reflections, object.getDeveloperName());

        // Find all the TypeProperties from the incoming object data, but we don't care about bindings here
        Set<TypePropertyFieldTuple> properties = this.createTypePropertyTuples(tClass)
                .collect(Collectors.toSet());

        return createTypeObjectFromObject(object, properties, tClass);
    }

    private <T> Stream<TypePropertyFieldTuple> createTypePropertyTuples(Class<T> tClass) {
        return reflections.getFieldsAnnotatedWith(TypeProperty.class).stream()
                .filter(field -> field.getDeclaringClass().equals(tClass))
                .map(field -> new TypePropertyFieldTuple(field.getAnnotation(TypeProperty.class), field));
    }

    private static Class<?> assertTypeElementExists(Reflections reflections, String objectName) throws Exception {
        Optional<Class<?>> objectType = reflections.getTypesAnnotatedWith(TypeElement.class).stream()
                .filter(type -> type.getAnnotation(TypeElement.class).name().equals(objectName))
                .findFirst();

        // Throw an error if an annotated type could not be found for the object type passed in
        if (!objectType.isPresent()) {
            throw new Exception("An annotated type could not be found with the name() " + objectName);
        }

        return objectType.get();
    }

    private <T> T createTypeObjectFromObject(MObject object, Set<TypePropertyFieldTuple> propertyFieldTuples, Class<T> tClass) throws Exception {
        T typeObject = tClass.newInstance();

        for (TypePropertyFieldTuple tuple : propertyFieldTuples) {
            object.getProperties().stream()
                    .filter(property -> property.getDeveloperName().equals(tuple.getTypeProperty().name()))
                    .forEach(Throwing.consumer(property -> this.setFieldValue(tuple, typeObject, property, tClass)));
        }

        // If the field is an ID field, set the value as the External ID and continue
        Optional<Field> idField = reflections.getFieldsAnnotatedWith(Id.class).stream()
                .filter(field -> field.getDeclaringClass().equals(tClass))
                .findFirst();

        if (idField.isPresent()) {
            idField.get().setAccessible(true);
            idField.get().set(typeObject, object.getExternalId());
        }

        return typeObject;
    }

    private <T> void setFieldValue(TypePropertyFieldTuple tuple, T typeObject, Property property, Class<T> tClass) throws Exception {
        Field field = tuple.getField();
        field.setAccessible(true);

        String propertyFullName = getPropertyFullName(field.getDeclaringClass().getSimpleName(), property.getDeveloperName());

        switch (tuple.getTypeProperty().contentType()) {
            case List:
                // Find the type of the list's generic
                Class<?> listType = getListPropertyGenericType(field, tuple.getTypeProperty().name());

                field.set(typeObject, this.parseList(property.getObjectData(), listType));
                break;
            case Object:
                field.set(typeObject, this.parseObject(property.getObjectData().get(0), field.getType()));
                break;
            default:
                field.set(typeObject, convertContentValueToTypedValue(propertyFullName, property.getContentValue(), property.getContentType(), field.getType()));
        }
    }

    /**
     * @param typeElementName the name of the type element the property is defined in
     * @param propertyField the field that the property is defined as in the type
     * @param typeProperty the type property to find the referenced type for
     * @return the developer name of the Type the property is referencing
     * @throws Exception when a referenced type could not be found
     */
    public static String getReferencedTypeName(String typeElementName, Field propertyField, TypeProperty typeProperty) throws Exception {
        return getReferencedTypeName(typeElementName, propertyField, typeProperty.referencedType(), typeProperty.name(), typeProperty.contentType());
    }

    public static String getReferencedTypeName(String typeElementName, Field propertyField, Class<?> referencedType, String propertyName, ContentType propertyContentType) throws Exception {
        if (referencedType.equals(void.class)) {
            if (propertyContentType.equals(ContentType.List)) {
                referencedType = getListPropertyGenericType(propertyField, propertyName);
            }

            if (propertyContentType.equals(ContentType.Object)) {
                referencedType = propertyField.getType();
            }
        }

        if (referencedType.equals(void.class)) {
            throw new Exception("The referenced type for " + getPropertyFullName(typeElementName, propertyName) + " cannot be null or void");
        }

        if (!referencedType.isAnnotationPresent(TypeElement.class)) {
            throw new Exception("The referenced type " + referencedType.getTypeName() + " is not annotated with @TypeElement");
        }

        return referencedType.getAnnotation(TypeElement.class).name();
    }

    public static Class<?> getListPropertyGenericType(Field propertyField, String propertyName) throws Exception {
        Class<?> genericType = TypeUtils.getGenericType(propertyField.getGenericType());

        String elementName = genericType.getAnnotation(TypeElement.class).name();

        if (Collection.class.isAssignableFrom(propertyField.getType())) {
            return genericType;
        }

        throw new Exception("The ContentList property " + getPropertyFullName(elementName, propertyName) + " does not have a Java type that inherits Collection<T>");
    }

    private static String getPropertyFullName(String elementName, String typePropertyName) {
        return elementName + "->" + typePropertyName;
    }

    private static <T> T convertContentValueToTypedValue(String property, String value, ContentType contentType, Class<T> type) {
        try {
            if (type.equals(long.class) || type.equals(Long.class)) {
                return (T) Long.decode(value);
            } else if (type.equals(boolean.class) || type.equals(Boolean.class)) {
                return (T) parseBoolean(value);
            } else if (type.equals(int.class) || type.equals(Integer.class)) {
                return (T) Integer.decode(value);
            } else if (type.equals(float.class) || type.equals(Float.class)) {
                return (T) Float.valueOf(value);
            } else if (type.equals(DateTime.class)) {
                return (T) DateTime.parse(value);
            } else if (type.equals(UUID.class)) {
                if (StringUtils.isNotBlank(value)) {
                    return (T) UUID.fromString(value);
                }

                return null;
            } else {
                return (T) value;
            }
        } catch (Exception exception) {
            throw new RuntimeException("Unable to populate the type property " + property + " as it is the wrong Java type. The correct type for the property should be " + getExpectedJavaType(contentType) + ".");
        }
    }

    private static String getExpectedJavaType(ContentType contentType) {
        switch (contentType) {
            case Boolean:
                return Boolean.class.getName();
            case DateTime:
                return DateTime.class.getName();
            case Number:
                return Integer.class.getName();
            case List:
            case Object:
                return "a custom type annotated with " + TypeElement.class.getName();
            case Content:
            case Encrypted:
            case Password:
            case String:
            default:
                return String.class.getName();
        }
    }

    private static Boolean parseBoolean(String value) {
        return value.equalsIgnoreCase("1") || !value.equalsIgnoreCase("0") && Boolean.parseBoolean(value);
    }
}