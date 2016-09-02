package com.manywho.sdk.services.files;

import java.io.InputStream;

public class FileUploadEntity {
    private InputStream content;

    private String name;

    public FileUploadEntity(InputStream content, String name) {
        this.content = content;
        this.name = name;
    }

    public InputStream getContent() {
        return content;
    }

    public String getName() {
        return name;
    }
}
