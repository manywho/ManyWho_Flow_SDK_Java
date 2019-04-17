package com.manywho.sdk.services.database;

import com.google.common.collect.Lists;
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

    public <T extends Type> ObjectDataResponse handle(ObjectDataRequest request, ReadOnlyDatabase<?, T> database) {
        ListFilter listFilter = getListFilter(request);

        List<MObject> result;

        // Check if the request is to find a single item, otherwise default to finding multiple items using the provided list filter
        if (listFilter.hasId()) {
            // If the request is to find a single item
            result = typeBuilder.from(database.find(
                    configurationParser.from(request),
                    request.getObjectDataType(),
                    request.getCommand(),
                    listFilter.getId()
            ));

            return createResponse(database.getClass(), result, 1);
        } else {
            // If a limit is provided, increment it by 1 so we can set the hasMoreResults flag
            int providedLimit = listFilter.getLimit();
            if (listFilter.hasLimit()) {
                listFilter.setLimit(providedLimit + 1);
            }

            result = typeBuilder.from(database.findAll(
                    configurationParser.from(request),
                    request.getObjectDataType(),
                    request.getCommand(),
                    listFilter
            ));

            return createResponse(database.getClass(), result, providedLimit);
        }
    }

    @Override
    public ObjectDataResponse handleRaw(ObjectDataRequest request, RawDatabase<?> database) {
        ListFilter listFilter = getListFilter(request);

        List<MObject> result;

        // Check if the request is to find a single item, otherwise default to finding multiple items using the provided list filter
        if (listFilter.hasId()) {
            result = Lists.newArrayList(database.find(
                    configurationParser.from(request),
                    request.getObjectDataType(),
                    request.getCommand(),
                    listFilter.getId()
            ));

            return createResponse(database.getClass(), result, 1);
        } else {
            // If a limit is provided, increment it by 1 so we can set the hasMoreResults flag
            int providedLimit = listFilter.getLimit();
            if (listFilter.hasLimit()) {
                listFilter.setLimit(providedLimit + 1);
            }

            result = database.findAll(
                    configurationParser.from(request),
                    request.getObjectDataType(),
                    request.getCommand(),
                    listFilter
            );

            return createResponse(database.getClass(), result, providedLimit);
        }
    }

    private ListFilter getListFilter(ObjectDataRequest request) {
        ListFilter listFilter = request.getListFilter();
        if (listFilter == null) {
            listFilter = new ListFilter();
            listFilter.setLimit(20);
            listFilter.setOffset(0);
        }

        return listFilter;
    }

    private ObjectDataResponse createResponse(Class<?> database, List<MObject> result, Integer providedLimit) {
        if (result == null) {
            throw new RuntimeException("The result from " + database.getCanonicalName() + "::findAll() cannot be null");
        }

        ObjectDataResponse response = new ObjectDataResponse();

        if (providedLimit != null && providedLimit != 0 && result.size() > providedLimit) {
            response.setHasMoreResults(true);
            response.setObjectData(result.subList(0, providedLimit));
        } else {
            response.setObjectData(result);
        }

        return response;
    }
}
