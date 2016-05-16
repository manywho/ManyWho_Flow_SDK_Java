package com.manywho.services.example.controllers;

import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.controllers.AbstractDataController;
import com.manywho.services.example.managers.DataManager;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Path;

@Path("/data")
public class DataController extends AbstractDataController {
    private final DataManager dataManager;

    @Inject
    public DataController(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public ObjectDataResponse delete(ObjectDataRequest objectDataRequest) throws Exception {
        return null;
    }

    @Override
    public ObjectDataResponse load(@Valid @NotNull ObjectDataRequest objectDataRequest) throws Exception {
        return dataManager.load(objectDataRequest);
    }

    @Override
    public ObjectDataResponse save(ObjectDataRequest objectDataRequest) throws Exception {
        return dataManager.save(objectDataRequest);
    }
}
