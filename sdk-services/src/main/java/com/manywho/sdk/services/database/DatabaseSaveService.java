package com.manywho.sdk.services.database;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.configuration.ConfigurationParser;
import com.manywho.sdk.services.types.Type;
import com.manywho.sdk.services.types.TypeBuilder;
import com.manywho.sdk.services.values.ValueParser;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class DatabaseSaveService implements DatabaseService {
    private final ConfigurationParser configurationParser;
    private final TypeBuilder typeBuilder;
    private final ValueParser valueParser;

    @Inject
    public DatabaseSaveService(ConfigurationParser configurationParser, TypeBuilder typeBuilder, ValueParser valueParser) {
        this.configurationParser = configurationParser;
        this.typeBuilder = typeBuilder;
        this.valueParser = valueParser;
    }

    public <T extends Type> ObjectDataResponse handle(ObjectDataRequest request, Class<T> type, WritableDatabase<?, T> database) {
        if (request.getObjectData() == null) {
            return new ObjectDataResponse();
        }

        List<MObject> objects = Lists.newArrayList();

        List<T> objectsToCreate = request.getObjectData().stream()
                .filter(object -> Strings.isNullOrEmpty(object.getExternalId()))
                .map(object -> valueParser.asObject(object, type))
                .collect(Collectors.toList());

        if (!objectsToCreate.isEmpty()) {
            if (objectsToCreate.size() == 1) {
                T createdObject = database.create(configurationParser.from(request), request.getObjectDataType(), objectsToCreate.get(0));
                if (createdObject == null) {
                    throw new RuntimeException("Creating a new object must return the created object with a populated identifier field");
                }

                objects.addAll(typeBuilder.from(createdObject));
            } else {
                List<T> createdObjects = database.create(configurationParser.from(request), request.getObjectDataType(), objectsToCreate);
                if (createdObjects == null) {
                    throw new RuntimeException("Creating a list of objects must return a list of the newly-created objects, including any populated identifier fields");
                }

                objects.addAll(typeBuilder.from(createdObjects));
            }
        }

        List<T> objectsToUpdate = request.getObjectData().stream()
                .filter(object -> !Strings.isNullOrEmpty(object.getExternalId()))
                .map(object -> valueParser.asObject(object, type))
                .collect(Collectors.toList());

        if (!objectsToUpdate.isEmpty()) {
            if (objectsToUpdate.size() == 1) {
                T updatedObject = database.update(configurationParser.from(request), request.getObjectDataType(), objectsToUpdate.get(0));
                if (updatedObject == null) {
                    throw new RuntimeException("Updating an object must return the same object along with any newly-updated fields");
                }

                objects.addAll(typeBuilder.from(updatedObject));
            } else {
                List<T> updatedObjects = database.update(configurationParser.from(request), request.getObjectDataType(), objectsToUpdate);
                if (updatedObjects == null) {
                    throw new RuntimeException("Updating a list must return a list containing all of the newly-updated objects");
                }

                objects.addAll(typeBuilder.from(updatedObjects));
            }
        }

        return new ObjectDataResponse(objects);
    }

    @Override
    public ObjectDataResponse handleRaw(ObjectDataRequest request, RawDatabase<?> database) {
        if (request.getObjectData() == null) {
            return new ObjectDataResponse();
        }

        List<MObject> objects = Lists.newArrayList();

        List<MObject> objectsToCreate = request.getObjectData().stream()
                .filter(object -> Strings.isNullOrEmpty(object.getExternalId()))
                .collect(Collectors.toList());

        List<MObject> objectsToUpdate = request.getObjectData().stream()
                .filter(object -> !Strings.isNullOrEmpty(object.getExternalId()))
                .collect(Collectors.toList());

        if (!objectsToCreate.isEmpty()) {
            if (objectsToCreate.size() == 1) {
                objects.add(database.create(configurationParser.from(request), request.getObjectDataType(), objectsToCreate.get(0)));
            } else {
                objects.addAll(database.create(configurationParser.from(request), request.getObjectDataType(), objectsToCreate));
            }
        }

        if (!objectsToUpdate.isEmpty()) {
            if (objectsToUpdate.size() == 1) {
                objects.add(database.update(configurationParser.from(request), request.getObjectDataType(), objectsToUpdate.get(0)));
            } else {
                objects.addAll(database.update(configurationParser.from(request), request.getObjectDataType(), objectsToUpdate));
            }
        }

        return new ObjectDataResponse(objects);
    }
}
