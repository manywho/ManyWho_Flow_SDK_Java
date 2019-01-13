package com.manywho.sdk.services.providers;

import com.google.inject.Provider;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadProvider implements Provider<FileUpload> {
    @Override
    public FileUpload get() {
        return new ServletFileUpload(new DiskFileItemFactory());
    }
}
