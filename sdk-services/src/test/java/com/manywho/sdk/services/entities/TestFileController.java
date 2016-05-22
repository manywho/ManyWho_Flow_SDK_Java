package com.manywho.sdk.services.entities;

import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.controllers.AbstractFileController;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import java.io.InputStream;

public class TestFileController extends AbstractFileController {

    @Override
    public ObjectDataResponse loadFiles(FileDataRequest fileDataRequest) throws Exception {
        return null;
    }

    @Override
    public ObjectDataResponse uploadFile(@FormDataParam("FileDataRequest") FileDataRequest fileDataRequest,
                                         @FormDataParam("file") FormDataContentDisposition fileInformation,
                                         @FormDataParam("file") InputStream file) throws Exception {
        return null;
    }

    @Override
    public ObjectDataResponse deleteFile(FileDataRequest fileDataRequest) throws Exception {
        return null;
    }
}
