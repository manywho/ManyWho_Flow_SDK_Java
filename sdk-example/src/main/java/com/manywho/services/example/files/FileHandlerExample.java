package com.manywho.services.example.files;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.run.elements.type.FileListFilter;
import com.manywho.sdk.services.files.FileHandler;
import com.manywho.sdk.services.files.FileUploadEntity;
import com.manywho.sdk.services.types.system.$File;
import com.manywho.services.example.ServiceConfiguration;

import java.util.List;

public class FileHandlerExample implements FileHandler<ServiceConfiguration> {

    @Override
    public List<$File> findAll(ServiceConfiguration configuration, FileListFilter listFilter, String path) {
        return Lists.newArrayList();
    }

    @Override
    public $File upload(ServiceConfiguration configuration, String path, FileUploadEntity uploadEntity) {
        return new $File("123", "name");
    }
}
