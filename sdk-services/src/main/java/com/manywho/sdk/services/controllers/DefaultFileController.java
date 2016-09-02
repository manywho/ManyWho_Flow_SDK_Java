package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.files.FileManager;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.inject.Inject;
import javax.ws.rs.Path;

@Path("/file")
public class DefaultFileController extends AbstractFileController {
    private final FileManager fileManager;

    @Inject
    public DefaultFileController(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public ObjectDataResponse deleteFile(FileDataRequest fileDataRequest) throws Exception {
        return null;
    }

    @Override
    public ObjectDataResponse loadFiles(FileDataRequest fileDataRequest) throws Exception {
        return null;
    }

    @Override
    public ObjectDataResponse uploadFile(MultipartFormDataInput multipartInput) throws Exception {
        return fileManager.uploadFile(multipartInput);
    }
}
