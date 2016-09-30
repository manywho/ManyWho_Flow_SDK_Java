package com.manywho.sdk.services.database;

import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.types.Type;

public interface DatabaseService {
    <T extends Type> ObjectDataResponse handle(ObjectDataRequest request, Class<T> type, Database<?, T> database);

    ObjectDataResponse handleRaw(ObjectDataRequest request, RawDatabase<?> database);
}
