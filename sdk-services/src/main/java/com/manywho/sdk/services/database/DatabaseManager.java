package com.manywho.sdk.services.database;

import com.google.common.base.Strings;
import com.google.inject.Injector;
import com.manywho.sdk.api.run.ServiceProblemException;
import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.configuration.ConfigurationParser;
import com.manywho.sdk.services.types.Type;
import com.manywho.sdk.services.types.TypeProvider;
import com.manywho.sdk.services.types.TypeRepository;

import javax.inject.Inject;

public class DatabaseManager {
    private final Injector injector;
    private final TypeProvider typeProvider;
    private final TypeRepository typeRepository;
    private final DatabaseRepository databaseRepository;
    private final DatabaseDeleteService databaseDeleteService;
    private final DatabaseLoadService databaseLoadService;
    private final DatabaseSaveService databaseSaveService;
    private final ConfigurationParser configurationParser;

    @Inject
    public DatabaseManager(
            Injector injector,
            TypeProvider typeProvider,
            TypeRepository typeRepository,
            DatabaseRepository databaseRepository,
            DatabaseDeleteService databaseDeleteService,
            DatabaseLoadService databaseLoadService,
            DatabaseSaveService databaseSaveService,
            ConfigurationParser configurationParser
    ) {
        this.injector = injector;
        this.typeProvider = typeProvider;
        this.typeRepository = typeRepository;
        this.databaseRepository = databaseRepository;
        this.databaseDeleteService = databaseDeleteService;
        this.databaseLoadService = databaseLoadService;
        this.databaseSaveService = databaseSaveService;
        this.configurationParser = configurationParser;
    }

    public ObjectDataResponse handle(DatabaseType databaseType, ObjectDataRequest objectDataRequest) {
        if (objectDataRequest == null) {
            throw new ServiceProblemException(400, "No incoming object data request was given");
        }

        if (objectDataRequest.getObjectDataType() == null) {
            throw new ServiceProblemException(400, "No object data type was given in the request");
        }

        if (Strings.isNullOrEmpty(objectDataRequest.getObjectDataType().getDeveloperName())) {
            throw new ServiceProblemException(400, "No object data type developer name was given in the request");
        }

        Configuration configuration = configurationParser.from(objectDataRequest);

        if (typeProvider.doesTypeExist(configuration, objectDataRequest.getObjectDataType().getDeveloperName())) {
            return handleCustomType(databaseType, objectDataRequest);
        } else {
            Class<? extends Type> type = typeRepository.findTypeElement(objectDataRequest.getObjectDataType().getDeveloperName());

            return handle(databaseType, objectDataRequest, type);
        }
    }

    private <T extends Type> ObjectDataResponse handle(DatabaseType databaseType, ObjectDataRequest request, Class<T> type) {
        switch (databaseType) {
            case Delete:
                return handleDelete(request, type);
            case Load:
                return handleLoad(request, type);
            default:
                return handleWrite(request, type);
        }
    }

    private <T extends Type> ObjectDataResponse handleDelete(ObjectDataRequest request, Class<T> type) {
        Class<? extends WritableDatabase<? ,T>> databaseClass = databaseRepository.findWritableDatabase(type);

        WritableDatabase<?, T> database = injector.getInstance(databaseClass);

        return databaseDeleteService.handle(request, type, database);
    }

    private <T extends Type> ObjectDataResponse handleLoad(ObjectDataRequest request, Class<T> type) {
        Class<? extends ReadOnlyDatabase<? ,T>> databaseClass = databaseRepository.findReadOnlyDatabase(type);

        ReadOnlyDatabase<?, T> database = injector.getInstance(databaseClass);

        return databaseLoadService.handle(request, database);
    }

    private <T extends Type> ObjectDataResponse handleWrite(ObjectDataRequest request, Class<T> type) {
        Class<? extends WritableDatabase<? ,T>> databaseClass = databaseRepository.findWritableDatabase(type);

        WritableDatabase<?, T> database = injector.getInstance(databaseClass);

        return databaseSaveService.handle(request, type, database);
    }

    private ObjectDataResponse handleCustomType(DatabaseType databaseType, ObjectDataRequest request) {
        Class<? extends RawDatabase<?>> databaseClass = databaseRepository.findRawDatabase();

        RawDatabase<?> database = injector.getInstance(databaseClass);

        switch (databaseType) {
            case Delete:
                return databaseDeleteService.handleRaw(request, database);
            case Load:
                return databaseLoadService.handleRaw(request, database);
            case Save:
                return databaseSaveService.handleRaw(request, database);
            default:
                throw new RuntimeException("The database type " + databaseType + " is not supported");
        }
    }
}
