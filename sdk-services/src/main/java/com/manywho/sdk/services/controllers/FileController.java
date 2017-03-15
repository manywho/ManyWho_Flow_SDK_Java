package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;

public interface FileController {
    ObjectDataResponse deleteFile(FileDataRequest fileDataRequest) throws Exception;

    ObjectDataResponse loadFiles(FileDataRequest fileDataRequest) throws Exception;

    // TODO: Figure out how we can do this without depending on the whole of Resteasy
//    ObjectDataResponse uploadFile(MultipartInput multipartFormDataInput) throws Exception;
}
