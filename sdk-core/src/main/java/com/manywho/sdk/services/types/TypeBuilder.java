package com.manywho.sdk.services.types;

import com.github.fge.lambdas.Throwing;
import com.manywho.sdk.entities.run.elements.type.*;
import com.manywho.sdk.entities.run.elements.type.Object;
import com.manywho.sdk.services.annotations.Id;
import com.manywho.sdk.services.annotations.TypeElement;
import com.manywho.sdk.services.annotations.TypeProperty;
import org.reflections.Reflections;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TypeBuilder {
    private Reflections reflections;

    @Inject
    public TypeBuilder(Reflections reflections) {
        this.reflections = reflections;
    }

    public <T> ObjectCollection buildList(ObjectDataRequest objectDataRequest, Collection<? extends T> objects, Class<T> tClass) throws Exception {
        return this.build(objectDataRequest, objects, tClass)
                .collect(Collectors.toCollection(ObjectCollection::new));
    }

    public <T> ObjectCollection buildObject(ObjectDataRequest objectDataRequest, T object, Class<T> tClass) throws Exception {
        List<T> temporaryObjectList = new ArrayList<>();
        temporaryObjectList.add(object);

        Optional<MObject> typeObjectOptional = this.build(objectDataRequest, temporaryObjectList, tClass)
                .limit(1)
                .findFirst();

        if (typeObjectOptional.isPresent()) {
            return new ObjectCollection(typeObjectOptional.get());
        }

        return new ObjectCollection();
    }

    private <T> Stream<MObject> build(ObjectDataRequest objectDataRequest, Collection<? extends T> objects, Class<T> tClass) throws Exception {
        ObjectDataTypePropertyCollection incomingProperties = objectDataRequest.getObjectDataType().getProperties();

        // Find all the TypeProperties that are set to "bound" and are in the incoming object data
        Set<TypePropertyFieldTuple> boundProperties = reflections.getFieldsAnnotatedWith(TypeProperty.class).stream()
                .filter(field -> field.getDeclaringClass().equals(tClass))
                .map(field -> new TypePropertyFieldTuple(field.getAnnotation(TypeProperty.class), field))
                .filter(tuple -> tuple.getTypeProperty().bound())
                .filter(tuple -> incomingProperties.stream().anyMatch(p -> p.getDeveloperName().equals(tuple.getTypeProperty().name())))
                .collect(Collectors.toSet());

        return objects.stream()
                .map(Throwing.function(object -> createObjectFromTypeObject(object, boundProperties, tClass)));
    }

    private <T> Object createObjectFromTypeObject(T typeObject, Set<TypePropertyFieldTuple> propertyFieldTuples, Class<T> tClass) throws Exception {
        TypeElement typeElement = tClass.getAnnotation(TypeElement.class);

        // If a field with the Id annotation is present, set the external ID in the ManyWho Object
        Optional<Field> idField = reflections.getFieldsAnnotatedWith(Id.class).stream()
                .filter(field -> field.getDeclaringClass().equals(tClass))
                .peek(field -> field.setAccessible(true))
                .findFirst();

        String externalId = null;
        if (idField.isPresent()) {
            externalId = String.valueOf(idField.get().get(typeObject));
        }

        PropertyCollection properties = propertyFieldTuples.stream()
                .peek(tuple -> tuple.getField().setAccessible(true))
                .map(Throwing.function(tuple -> new Property(tuple.getTypeProperty().name(), tuple.getField().get(typeObject))))
                .collect(Collectors.toCollection(PropertyCollection::new));

        return new Object(typeElement.name(), externalId, properties);
    }
}