package com.manywho.sdk.services.database;

import com.google.common.collect.Lists;
import com.google.inject.Injector;
import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.types.Type;
import com.manywho.sdk.services.types.TypeBuilder;
import com.manywho.sdk.services.types.TypeRepository;
import com.manywho.sdk.services.values.ValueParser;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class DatabaseManager {
    private final Injector injector;
    private final DatabaseRepository databaseRepository;
    private final TypeRepository typeRepository;
    private final TypeBuilder typeBuilder;
    private final ValueParser valueParser;

    @Inject
    public DatabaseManager(Injector injector, DatabaseRepository databaseRepository, TypeRepository typeRepository, TypeBuilder typeBuilder, ValueParser valueParser) {
        this.injector = injector;
        this.databaseRepository = databaseRepository;
        this.typeRepository = typeRepository;
        this.typeBuilder = typeBuilder;
        this.valueParser = valueParser;
    }

    public ObjectDataResponse delete(ObjectDataRequest objectDataRequest) {
        Class<? extends Type> type = typeRepository.findTypeElement(objectDataRequest.getObjectDataType().getDeveloperName());

        handleDelete(objectDataRequest, type);

        return new ObjectDataResponse();
    }

    public ObjectDataResponse load(ObjectDataRequest objectDataRequest) {
        Class<? extends Type> type = typeRepository.findTypeElement(objectDataRequest.getObjectDataType().getDeveloperName());

        // If a limit is provided, increment it by 1 so we can set the hasMoreResults flag
        ListFilter providedListFilter = objectDataRequest.getListFilter();
        if (objectDataRequest.getListFilter().hasLimit()) {
            objectDataRequest.getListFilter().setLimit(providedListFilter.getLimit() + 1);
        }

        List<MObject> objects = handleLoad(objectDataRequest, type);

        ObjectDataResponse response = new ObjectDataResponse();

        if (objects.size() > providedListFilter.getLimit()) {
            response.setHasMoreResults(true);
            response.setObjectData(objects.subList(0, objects.size()));
        } else {
            response.setObjectData(objects);
        }

        return response;
    }

    public ObjectDataResponse save(ObjectDataRequest objectDataRequest) {
        Class<? extends Type> type = typeRepository.findTypeElement(objectDataRequest.getObjectDataType().getDeveloperName());

        List<MObject> objects = handleSave(objectDataRequest, type);

        return new ObjectDataResponse(objects);
    }

    private <T extends Type> void handleDelete(ObjectDataRequest objectDataRequest, Class<T> type) {
        Class<? extends Database<T>> databaseClass = databaseRepository.findDatabase(type);

        Database<T> database = injector.getInstance(databaseClass);

        if (objectDataRequest.getObjectData() == null) {
            return;
        }

        List<T> objects = valueParser.asList(objectDataRequest.getObjectData(), type);

        if (objects.size() == 1) {
            database.delete(objects.get(0));
        } else {
            database.delete(objects);
        }
    }

    private <T extends Type> List<MObject> handleFindMultiple(ObjectDataRequest request, Database<T> database) {
        return typeBuilder.from(database.findAll(request.getListFilter()));
    }

    private <T extends Type> List<MObject> handleFindSingle(ObjectDataRequest request, Database<T> database) {
        return typeBuilder.from(database.find(request.getListFilter().getId()));
    }

    private <T extends Type> List<MObject> handleLoad(ObjectDataRequest objectDataRequest, Class<T> type) {
        Class<? extends Database<T>> databaseClass = databaseRepository.findDatabase(type);

        Database<T> database = injector.getInstance(databaseClass);

        // If the request is to find a single item
        if (objectDataRequest.getListFilter().hasId()) {
            return handleFindSingle(objectDataRequest, database);
        }

        // Otherwise we default to finding multiple items using the provided list filter
        return handleFindMultiple(objectDataRequest, database);
    }

    private <T extends Type> List<MObject> handleSave(ObjectDataRequest objectDataRequest, Class<T> type) {
        Class<? extends Database<T>> databaseClass = databaseRepository.findDatabase(type);

        Database<T> database = injector.getInstance(databaseClass);

        List<MObject> objects = Lists.newArrayList();

        if (objectDataRequest.getObjectData() == null) {
            return objects;
        }

        List<T> objectsToCreate = objectDataRequest.getObjectData().stream()
                .filter(object -> StringUtils.isEmpty(object.getExternalId()))
                .map(object -> valueParser.asObject(object, type))
                .collect(Collectors.toList());

        if (!objectsToCreate.isEmpty()) {
            if (objectsToCreate.size() == 1) {
                objects.addAll(typeBuilder.from(database.create(objectsToCreate.get(0))));
            } else {
                objects.addAll(typeBuilder.from(database.create(objectsToCreate)));
            }
        }

        List<T> objectsToUpdate = objectDataRequest.getObjectData().stream()
                .filter(object -> StringUtils.isNotEmpty(object.getExternalId()))
                .map(object -> valueParser.asObject(object, type))
                .collect(Collectors.toList());

        if (!objectsToUpdate.isEmpty()) {
            if (objectsToUpdate.size() == 1) {
                objects.addAll(typeBuilder.from(database.update(objectsToUpdate.get(0))));
            } else {
                objects.addAll(typeBuilder.from(database.update(objectsToUpdate)));
            }
        }

        return objects;
    }
}
