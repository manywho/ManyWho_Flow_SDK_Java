package com.manywho.sdk.services.database;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.configuration.ConfigurationParser;
import com.manywho.sdk.services.types.Type;
import com.manywho.sdk.services.types.TypeBuilder;
import com.manywho.sdk.services.values.ValueParser;
import org.apache.commons.lang3.StringUtils;

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

    @Override
    public <T extends Type> ObjectDataResponse handle(ObjectDataRequest request, Class<T> type, Database<?, T> database) {
        if (request.getObjectData() == null) {
            return new ObjectDataResponse();
        }

        List<MObject> objects = Lists.newArrayList();

        List<T> objectsToCreate = request.getObjectData().stream()
                .filter(object -> StringUtils.isEmpty(object.getExternalId()))
                .map(object -> valueParser.asObject(object, type))
                .collect(Collectors.toList());

        if (!objectsToCreate.isEmpty()) {
            if (objectsToCreate.size() == 1) {
                objects.addAll(typeBuilder.from(database.create(configurationParser.from(request), objectsToCreate.get(0))));
            } else {
                objects.addAll(typeBuilder.from(database.create(configurationParser.from(request), objectsToCreate)));
            }
        }

        List<T> objectsToUpdate = request.getObjectData().stream()
                .filter(object -> StringUtils.isNotEmpty(object.getExternalId()))
                .map(object -> valueParser.asObject(object, type))
                .collect(Collectors.toList());

        if (!objectsToUpdate.isEmpty()) {
            if (objectsToUpdate.size() == 1) {
                objects.addAll(typeBuilder.from(database.update(configurationParser.from(request), objectsToUpdate.get(0))));
            } else {
                objects.addAll(typeBuilder.from(database.update(configurationParser.from(request), objectsToUpdate)));
            }
        }

        return new ObjectDataResponse(objects);
    }

    @Override
    public ObjectDataResponse handleRaw(ObjectDataRequest request, RawDatabase<?, MObject> database) {
        if (request.getObjectData() == null) {
            return new ObjectDataResponse();
        }

        List<MObject> objects = Lists.newArrayList();

        List<MObject> objectsToCreate = request.getObjectData().stream()
                .filter(object -> StringUtils.isEmpty(object.getExternalId()))
                .collect(Collectors.toList());

        List<MObject> objectsToUpdate = request.getObjectData().stream()
                .filter(object -> StringUtils.isNotEmpty(object.getExternalId()))
                .collect(Collectors.toList());

        if (!objectsToCreate.isEmpty()) {
            if (objectsToCreate.size() == 1) {
                objects.add(database.create(configurationParser.from(request), objectsToCreate.get(0)));
            } else {
                objects.addAll(database.create(configurationParser.from(request), objectsToCreate));
            }
        }

        if (!objectsToUpdate.isEmpty()) {
            if (objectsToUpdate.size() == 1) {
                objects.add(database.update(configurationParser.from(request), objectsToUpdate.get(0)));
            } else {
                objects.addAll(database.update(configurationParser.from(request), objectsToUpdate));
            }
        }

        return new ObjectDataResponse(objects);
    }
}
