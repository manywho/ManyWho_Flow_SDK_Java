package com.manywho.sdk.services.database;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.configuration.ConfigurationParser;
import com.manywho.sdk.services.types.Type;
import com.manywho.sdk.services.types.TypeBuilder;

import javax.inject.Inject;
import java.util.List;

public class DatabaseLoadService implements DatabaseService {
    private final ConfigurationParser configurationParser;
    private final TypeBuilder typeBuilder;

    @Inject
    public DatabaseLoadService(ConfigurationParser configurationParser, TypeBuilder typeBuilder) {
        this.configurationParser = configurationParser;
        this.typeBuilder = typeBuilder;
    }

    @Override
    public <T extends Type> ObjectDataResponse handle(ObjectDataRequest request, Class<T> type, Database<?, T> database) {
        // If a limit is provided, increment it by 1 so we can set the hasMoreResults flag
        int providedLimit = request.getListFilter().getLimit();
        if (request.getListFilter().hasLimit()) {
            request.getListFilter().setLimit(providedLimit + 1);
        }

        List<MObject> result;

        if (request.getListFilter().hasId()) {
            // If the request is to find a single item
            result = typeBuilder.from(database.find(configurationParser.from(request), request.getListFilter().getId()));
        } else {
            // Otherwise we default to finding multiple items using the provided list filter
            result = typeBuilder.from(database.findAll(configurationParser.from(request), request.getListFilter()));
        }

        return createResponse(result, providedLimit);
    }

    @Override
    public ObjectDataResponse handleRaw(ObjectDataRequest request, RawDatabase<?> database) {
        // If a limit is provided, increment it by 1 so we can set the hasMoreResults flag
        int providedLimit = request.getListFilter().getLimit();
        if (request.getListFilter().hasLimit()) {
            request.getListFilter().setLimit(providedLimit + 1);
        }

        List<MObject> result;

        if (request.getListFilter().hasId()) {
            // If the request is to find a single item
            result = Lists.newArrayList(database.find(configurationParser.from(request), request.getObjectDataType(), request.getListFilter().getId()));
        } else {
            // Otherwise we default to finding multiple items using the provided list filter
            result = database.findAll(configurationParser.from(request), request.getObjectDataType(), request.getListFilter());
        }

        if (result == null) {
            throw new RuntimeException("The result from " + database.getClass().getCanonicalName() + "::findAll() cannot be null");
        }

        return createResponse(result, providedLimit);
    }

    private ObjectDataResponse createResponse(List<MObject> result, int providedLimit) {
        ObjectDataResponse response = new ObjectDataResponse();

        if (providedLimit != 0 && result.size() > providedLimit) {
            response.setHasMoreResults(true);
            response.setObjectData(result.subList(0, providedLimit));
        } else {
            response.setObjectData(result);
        }

        return response;
    }
}
