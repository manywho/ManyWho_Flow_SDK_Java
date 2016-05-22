package com.manywho.sdk.services.database;

import com.manywho.sdk.api.run.elements.type.ListFilter;
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
        ListFilter providedListFilter = request.getListFilter();
        if (request.getListFilter().hasLimit()) {
            request.getListFilter().setLimit(providedListFilter.getLimit() + 1);
        }

        List<MObject> result;

        if (request.getListFilter().hasId()) {
            // If the request is to find a single item
            result = handleFindSingle(request, database);
        } else {
            // Otherwise we default to finding multiple items using the provided list filter
            result = handleMultiple(request, database);
        }

        ObjectDataResponse response = new ObjectDataResponse();

        if (result.size() > providedListFilter.getLimit()) {
            response.setHasMoreResults(true);
            response.setObjectData(result.subList(0, result.size()));
        } else {
            response.setObjectData(result);
        }

        return response;
    }

    private <T extends Type> List<MObject> handleMultiple(ObjectDataRequest request, Database<?, T> database) {
        return typeBuilder.from(database.findAll(configurationParser.from(request), request.getListFilter()));
    }

    private <T extends Type> List<MObject> handleFindSingle(ObjectDataRequest request, Database<?, T> database) {
        return typeBuilder.from(database.find(configurationParser.from(request), request.getListFilter().getId()));
    }
}
