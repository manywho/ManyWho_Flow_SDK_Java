package com.manywho.sdk.services.database;

import com.google.inject.Injector;
import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.types.Type;
import com.manywho.sdk.services.types.TypeRepository;

import javax.inject.Inject;

public class DatabaseManager {
    private final Injector injector;
    private final TypeRepository typeRepository;
    private final DatabaseRepository databaseRepository;
    private final DatabaseServiceFactory databaseServiceFactory;

    @Inject
    public DatabaseManager(
            Injector injector,
            TypeRepository typeRepository,
            DatabaseRepository databaseRepository,
            DatabaseServiceFactory databaseServiceFactory
    ) {
        this.injector = injector;
        this.typeRepository = typeRepository;
        this.databaseRepository = databaseRepository;
        this.databaseServiceFactory = databaseServiceFactory;
    }

    public ObjectDataResponse handle(DatabaseType databaseType, ObjectDataRequest objectDataRequest) {
        Class<? extends Type> type = typeRepository.findTypeElement(objectDataRequest.getObjectDataType().getDeveloperName());

        return handle(databaseType, objectDataRequest, type);
    }

    private <T extends Type> ObjectDataResponse handle(DatabaseType databaseType, ObjectDataRequest request, Class<T> type) {
        Class<? extends Database<?, T>> databaseClass = databaseRepository.findDatabase(type);

        Database<?, T> database = injector.getInstance(databaseClass);

        return databaseServiceFactory.create(databaseType).handle(request, type, database);
    }
}
