package com.manywho.sdk.services.types;

import com.github.fge.lambdas.Throwing;
import com.manywho.sdk.entities.run.elements.type.MObject;
import com.manywho.sdk.entities.run.elements.type.ObjectCollection;
import com.manywho.sdk.entities.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.entities.run.elements.type.Property;
import com.manywho.sdk.entities.run.elements.type.PropertyCollection;
import com.manywho.sdk.enums.ContentType;
import com.manywho.sdk.services.annotations.Id;
import com.manywho.sdk.services.annotations.TypeElement;
import com.manywho.sdk.services.annotations.TypeProperty;
import com.manywho.sdk.services.exceptions.MissingTypeReferenceException;
import com.manywho.sdk.services.exceptions.TypePropertyNotCollectionException;
import org.reflections.Reflections;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TypeBuilder {
    private Reflections reflections;

    @Inject
    public TypeBuilder(Reflections reflections) {
        this.reflections = reflections;
    }

    /**
     * @param objectDataRequest the incoming request for the database call
     * @param objects a #{@link Collection} of objects to build the list from
     * @param tClass the #{@link Class} of the incoming type to build a list from
     * @param <T> the generic type of the Type to build a list from
     * @return a collection of ManyWho Objects
     * @throws Exception when the list fails to build
     */
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

        // TODO
        return new ObjectCollection();
    }

    private <T> Stream<MObject> build(ObjectDataRequest objectDataRequest, Collection<? extends T> objects, Class<T> tClass) throws Exception {
        // Find all the TypeProperties that are set to "bound"
        Stream<TypePropertyFieldTuple> propertyTuples = reflections.getFieldsAnnotatedWith(TypeProperty.class).stream()
                .filter(field -> field.getDeclaringClass().equals(tClass))
                .map(this::createTypePropertyFieldTuple)
                .filter(tuple -> tuple.getTypeProperty().bound());

        // If an ObjectDataRequest was passed in, then filter the tuples by properties that are in the request
        if (objectDataRequest != null) {
            propertyTuples = propertyTuples
                    .filter(tuple -> this.isPropertyInObjectDataRequest(tuple.getTypeProperty(), objectDataRequest));
        }

        Set<TypePropertyFieldTuple> boundProperties = propertyTuples.collect(Collectors.toSet());

        return objects.stream()
                .map(Throwing.function(object -> createObjectFromTypeObject(object, boundProperties, tClass)));
    }

    private TypePropertyFieldTuple createTypePropertyFieldTuple(Field field) {
        return new TypePropertyFieldTuple(field.getAnnotation(TypeProperty.class), field);
    }

    private <T> MObject createObjectFromTypeObject(T typeObject, Set<TypePropertyFieldTuple> propertyFieldTuples, Class<T> tClass) throws Exception {
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
                .map(Throwing.function(tuple -> createPropertyFromTuple(tuple, typeObject)))
                .collect(Collectors.toCollection(PropertyCollection::new));

        return new MObject(typeElement.name(), externalId, properties);
    }

    /**
     * Check whether an incoming #{@link ObjectDataRequest} contains a certain #{@link TypeProperty}
     *
     * @param property the #{@link TypeProperty} annotation for the property we're checking
     * @param objectDataRequest the incoming request for the database call
     * @return whether the incoming request contains a binding that includes the property we're checking
     */
    private boolean isPropertyInObjectDataRequest(TypeProperty property, ObjectDataRequest objectDataRequest) {
        return objectDataRequest.getObjectDataType().getProperties().stream()
                .anyMatch(p -> p.getDeveloperName().equals(property.name()));
    }

    private <T> Property createPropertyFromTuple(TypePropertyFieldTuple tuple, T typeObject) throws Exception {
        switch (tuple.getTypeProperty().contentType()) {
            case Object:
                return this.createObjectPropertyFromTuple(tuple, typeObject, tuple.getField().getType());
            case List:
                return this.createListPropertyFromTuple(tuple, typeObject, tuple.getTypeProperty().referencedType());
            default:
                return new Property(tuple.getTypeProperty().name(), tuple.getField().get(typeObject));
        }
    }

    /**
     * @param tuple a tuple containing a #{@link TypeProperty} and a #{@link Field} to base the created property on
     * @param typeObject a generic object that contains the values for the property we want to fetch
     * @param fieldClass the #{@link Class} of the incoming #{@link Field} to pass into the call to #{@link TypeBuilder#buildObject(ObjectDataRequest, java.lang.Object, Class)}
     * @return a new property created from the values in the incoming tuple
     * @throws Exception
     */
    private <T, F> Property createObjectPropertyFromTuple(TypePropertyFieldTuple tuple, T typeObject, Class<F> fieldClass) throws Exception {
        // Attempt to cast the field's value to the incoming generic type, otherwise return a Property with null object data
        F fieldObject = (F) tuple.getField().get(typeObject);
        if (fieldObject == null) {
            return new Property(tuple.getTypeProperty().name());
        }

        return new Property(tuple.getTypeProperty().name(), this.buildObject(null, fieldObject, fieldClass));
    }

    private <T, F> Property createListPropertyFromTuple(TypePropertyFieldTuple tuple, T typeObject, Class<F> fieldClass) throws Exception {
        // Check if a type reference was passed in correctly
        if (fieldClass == null) {
            throw new MissingTypeReferenceException(tuple.getTypeProperty().name(), ContentType.List);
        }

        // Check if the tuple's field is a collection or not
        if (!Collection.class.isAssignableFrom(tuple.getField().getType())) {
            throw new TypePropertyNotCollectionException(tuple.getField().getName(), tuple.getField().getDeclaringClass().getTypeName());
        }

        Collection<? extends F> typeProperties = (Collection<? extends F>) tuple.getField().get(typeObject);
        if (typeProperties == null) {
            // If the collection hasn't been initialized (distinct from it being empty), then return a Property with null object data
            return new Property(tuple.getTypeProperty().name());
        }

        return new Property(tuple.getTypeProperty().name(), this.buildList(null, typeProperties, fieldClass));
    }
}