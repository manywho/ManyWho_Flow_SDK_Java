package com.manywho.services.example.files;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.run.elements.type.FileListFilter;
import com.manywho.sdk.services.files.FileHandler;
import com.manywho.sdk.services.files.FileUpload;
import com.manywho.sdk.services.types.system.$File;
import com.manywho.services.example.ServiceConfiguration;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileHandlerExample implements FileHandler<ServiceConfiguration> {

    @Override
    public List<$File> findAll(ServiceConfiguration configuration, FileListFilter listFilter, String path) {
        List<$File> files = Lists.newArrayList();

        if (path != null && path.equals("a-real-path")) {
            files.add(new $File("file-1", "File One", "text/html", "https://example.com/file-one"));
            files.add(new $File("file-2", "File Two", "image/jpeg", "https://example.com/file-two"));
        }

        return files;
    }

    @Override
    public $File upload(ServiceConfiguration configuration, String path, FileUpload upload) {
        try {
            Files.write(Paths.get(path), IOUtils.toByteArray(upload.getContent()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new $File("123", "name");
    }
}
