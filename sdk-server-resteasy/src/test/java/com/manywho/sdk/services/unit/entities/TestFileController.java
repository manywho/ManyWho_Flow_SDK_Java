package com.manywho.sdk.services.unit.entities;

import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.controllers.AbstractFileController;

import javax.servlet.http.HttpServletRequest;

public class TestFileController extends AbstractFileController {

    @Override
    public ObjectDataResponse deleteFile(FileDataRequest fileDataRequest) throws Exception {
        return null;
    }

    @Override
    public ObjectDataResponse loadFiles(FileDataRequest fileDataRequest) throws Exception {
        return null;
    }

    @Override
    public ObjectDataResponse uploadFile(HttpServletRequest request) throws Exception {
        return null;
    }
}
