package com.manywho.sdk.services.database;

import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;

public interface DatabaseService {
    ObjectDataResponse handleRaw(ObjectDataRequest request, RawDatabase<?> database);
}
