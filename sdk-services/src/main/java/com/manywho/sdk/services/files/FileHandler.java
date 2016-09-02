package com.manywho.sdk.services.files;

import com.manywho.sdk.api.run.elements.type.ListFilter;
import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.types.system.$File;

import java.util.List;

public interface FileHandler<C extends Configuration> {

    List<$File> findAll(C configuration, ListFilter listFilter, String path);

    $File upload(C configuration, String path, FileUploadEntity uploadEntity);
}
