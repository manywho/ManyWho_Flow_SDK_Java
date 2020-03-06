package com.manywho.sdk.services.database;

import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.configuration.ConfigurationParser;
import com.manywho.sdk.services.types.Type;
import com.manywho.sdk.services.values.ValueParser;

import javax.inject.Inject;

public class DatabaseDeleteService implements DatabaseService {
    private final ConfigurationParser configurationParser;
    private final ValueParser valueParser;

    @Inject
    public DatabaseDeleteService(ConfigurationParser configurationParser, ValueParser valueParser) {
        this.configurationParser = configurationParser;
        this.valueParser = valueParser;
    }

    public <T extends Type> ObjectDataResponse handle(ObjectDataRequest request, Class<T> type, WritableDatabase<?, T> database) {
        if (request.getObjectData() == null) {
            return new ObjectDataResponse();
        }

        if (request.getObjectData().size() == 1) {
            database.delete(configurationParser.from(request), request.getObjectDataType(), valueParser.asObject(request.getObjectData(), type));
        } else {
            database.delete(configurationParser.from(request), request.getObjectDataType(), valueParser.asList(request.getObjectData(), type));
        }

        return new ObjectDataResponse();
    }

    @Override
    public ObjectDataResponse handleRaw(ObjectDataRequest request, RawDatabase<?> database) {
        if (request.getObjectData() == null) {
            return new ObjectDataResponse();
        }

        if (request.getObjectData().size() == 1) {
            database.delete(configurationParser.from(request), request.getObjectDataType(), request.getObjectData().get(0));
        } else {
            database.delete(configurationParser.from(request), request.getObjectDataType(), request.getObjectData());
        }

        return new ObjectDataResponse();
    }
}
