package com.manywho.sdk.services.unit.entities;

import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.controllers.AbstractFileController;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

public class TestFileController extends AbstractFileController {

    @Override
    public ObjectDataResponse uploadFile(MultipartFormDataInput multipartFormDataInput) throws Exception {
        return null;
    }
}
