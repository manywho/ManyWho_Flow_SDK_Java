package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.database.DatabaseManager;
import com.manywho.sdk.services.database.DatabaseType;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Path;

@Path("/data")
public class DefaultDatabaseController extends AbstractDataController {
    private final DatabaseManager databaseManager;

    @Inject
    public DefaultDatabaseController(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }

    @Override
    public ObjectDataResponse delete(ObjectDataRequest objectDataRequest) throws Exception {
        return databaseManager.handle(DatabaseType.Delete, objectDataRequest);
    }

    @Override
    public ObjectDataResponse load(@Valid @NotNull ObjectDataRequest objectDataRequest) throws Exception {
        return databaseManager.handle(DatabaseType.Load, objectDataRequest);
    }

    @Override
    public ObjectDataResponse save(ObjectDataRequest objectDataRequest) throws Exception {
        return databaseManager.handle(DatabaseType.Save, objectDataRequest);
    }
}
