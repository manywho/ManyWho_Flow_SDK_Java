package com.manywho.sdk.services.unit.entities;

import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.controllers.FileController;

public class TestFileController implements FileController {

    @Override
    public ObjectDataResponse deleteFile(FileDataRequest fileDataRequest) throws Exception {
        return null;
    }

    @Override
    public ObjectDataResponse loadFiles(FileDataRequest fileDataRequest) throws Exception {
        return null;
    }

//    @Override
//    public ObjectDataResponse uploadFile(MultipartInput multipartFormDataInput) throws Exception {
//        return null;
//    }
}
