package com.manywho.sdk.services.files;

import com.google.inject.Injector;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.services.types.TypeBuilder;
import com.manywho.sdk.services.types.system.$File;

import javax.inject.Inject;
import java.util.List;

public class FileService {
    private final TypeBuilder typeBuilder;
    private final Injector injector;

    @Inject
    public FileService(TypeBuilder typeBuilder, Injector injector) {
        this.typeBuilder = typeBuilder;
        this.injector = injector;
    }

    public FileHandler createFileHandler(Class<? extends FileHandler> handlerClass) {
        return injector.getInstance(handlerClass);
    }

    public List<MObject> createFileObject($File file) {
        return typeBuilder.from(file);
    }
}
