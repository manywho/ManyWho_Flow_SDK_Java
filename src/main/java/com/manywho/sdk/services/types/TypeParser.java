package com.manywho.sdk.services.types;

import com.github.fge.lambdas.Throwing;
import com.manywho.sdk.entities.run.elements.type.MObject;
import com.manywho.sdk.entities.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.entities.run.elements.type.ObjectDataTypePropertyCollection;
import com.manywho.sdk.services.annotations.Id;
import com.manywho.sdk.services.annotations.TypeElement;
import com.manywho.sdk.services.annotations.TypeProperty;
import org.apache.commons.collections4.CollectionUtils;
import org.reflections.Reflections;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class TypeParser {
    private Reflections reflections;

    @Inject
    public TypeParser(Reflections reflections) {
        this.reflections = reflections;
    }

    public <T> List<T> parse(ObjectDataRequest objectDataRequest, Class<T> tClass) throws Exception {
        String objectDataType = objectDataRequest.getObjectDataType().getDeveloperName();

        // Find the type that was passed in
        Optional<Class<?>> objectType = reflections.getTypesAnnotatedWith(TypeElement.class).stream()
                .filter(type -> type.getAnnotation(TypeElement.class).name().equals(objectDataType))
                .findFirst();

        // Throw an error if an annotated type could not be found for the object type passed in
        if (!objectType.isPresent()) {
            throw new Exception("An annotated type could not be found with the name() " + objectDataType);
        }

        // Return an empty list if the incoming request contains no data
        if (CollectionUtils.isEmpty(objectDataRequest.getObjectData())) {
            return new ArrayList<>();
        }

        ObjectDataTypePropertyCollection incomingProperties = objectDataRequest.getObjectDataType().getProperties();

        // Find all the TypeProperties that are set to "bound" and are in the incoming object data
        Set<TypePropertyFieldTuple> boundProperties = reflections.getFieldsAnnotatedWith(TypeProperty.class).stream()
                .map(field -> new TypePropertyFieldTuple(field.getAnnotation(TypeProperty.class), field))
                .filter(tuple -> tuple.getTypeProperty().bound())
                .filter(tuple -> incomingProperties.stream().anyMatch(p -> p.getDeveloperName().equals(tuple.getTypeProperty().name())))
                .collect(Collectors.toSet());

        // Return an empty list if no bound properties were found
        if (CollectionUtils.isEmpty(boundProperties)) {
            return new ArrayList<>();
        }

        return objectDataRequest.getObjectData().stream()
                .map(Throwing.function(object -> createTypeObjectFromObject(object, boundProperties, tClass)))
                .collect(Collectors.toList());
    }

    private <T> T createTypeObjectFromObject(MObject object, Set<TypePropertyFieldTuple> propertyFieldTuples, Class<T> tClass) throws Exception {
        T typeObject = tClass.newInstance();

        for (TypePropertyFieldTuple tuple : propertyFieldTuples) {
            object.getProperties().stream()
                    .filter(property -> property.getDeveloperName().equals(tuple.getTypeProperty().name()))
                    .forEach(Throwing.consumer(property -> {
                        tuple.getField().setAccessible(true);
                        tuple.getField().set(typeObject, property.getContentValue());
                    }));
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
}
