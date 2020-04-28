package com.manywho.sdk.services.files;

import org.reflections.Reflections;

import javax.inject.Inject;
import java.util.Set;

public class FileRepository {
    private final Reflections reflections;

    @Inject
    public FileRepository(Reflections reflections) {
        this.reflections = reflections;
    }

    public Class<? extends FileHandler> getFileHandler() {
        Set<Class<? extends FileHandler>> handlers = reflections.getSubTypesOf(FileHandler.class);

        if (handlers.isEmpty()) {
            throw new RuntimeException("No file handler was found in your service");
        }

        if (handlers.size() > 1) {
            throw new RuntimeException("Your service may only have one file handler");
        }

        return handlers.iterator().next();
    }
}
