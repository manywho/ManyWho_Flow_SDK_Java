package com.manywho.sdk.services.database;

import javax.inject.Inject;

public class DatabaseServiceFactory {
    private final DatabaseDeleteService deleteService;
    private final DatabaseLoadService loadService;
    private final DatabaseSaveService saveService;

    @Inject
    public DatabaseServiceFactory(
            DatabaseDeleteService deleteService,
            DatabaseLoadService loadService,
            DatabaseSaveService saveService
    ) {
        this.deleteService = deleteService;
        this.loadService = loadService;
        this.saveService = saveService;
    }

    public DatabaseService create(DatabaseType type) {
        switch (type) {
            case Delete:
                return deleteService;
            case Load:
                return loadService;
            case Save:
                return saveService;
            default:
                throw new RuntimeException("An unsupported database type (" + type + ") was given");
        }
    }
}
