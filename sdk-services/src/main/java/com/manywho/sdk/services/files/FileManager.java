package com.manywho.sdk.services.files;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.api.run.ServiceProblemException;
import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.configuration.ConfigurationParser;
import com.manywho.sdk.services.types.system.$File;
import org.apache.commons.fileupload.FileItem;

import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FileManager {
    private final ConfigurationParser configurationParser;
    private final FileRepository fileRepository;
    private final FileService fileService;
    private final ObjectMapper objectMapper;

    @Inject
    public FileManager(ConfigurationParser configurationParser, FileRepository fileRepository, FileService fileService, ObjectMapper objectMapper) {
        this.configurationParser = configurationParser;
        this.fileRepository = fileRepository;
        this.fileService = fileService;
        this.objectMapper = objectMapper;
    }

    @SuppressWarnings("unchecked")
    public ObjectDataResponse loadFiles(FileDataRequest request) {
        // Create the configuration settings from the request
        Configuration configuration = configurationParser.from(request);

        // Load the list of files from the service
        List<$File> files = fileService.createFileHandler(fileRepository.getFileHandler())
                .findAll(configuration, request.getListFilter(), request.getResourcePath());

        return new ObjectDataResponse(fileService.createFileObjects(files));
    }

    public ObjectDataResponse uploadFile(List<FileItem> files) {
        // Get the first part that has a content type of "application/json", as it's probably the FileDataRequest
        FileDataRequest request = files.stream()
                .filter(item -> item.getContentType().contains("application/json"))
                .findFirst()
                .map(item -> parseFileDataRequest(getFileItemStream(item)))
                .orElse(null);

        // Get the first part that doesn't have a content type of "application/json" as it's probably the file content
        FileUpload upload = files.stream()
                .filter(item -> item.getContentType() == null || item.getContentType().contains("application/json") == false)
                .findFirst()
                .map(item -> new FileUpload(getFileItemStream(item), item.getName()))
                .orElse(null);

        return uploadFile(request, upload);
    }

    @SuppressWarnings("unchecked")
    public ObjectDataResponse uploadFile(FileDataRequest request, FileUpload upload) {
        if (request == null) {
            throw new ServiceProblemException(400, "No file data request was given");
        }

        if (upload == null || upload.getContent() == null) {
            throw new ServiceProblemException(400, "No file was uploaded");
        }

        // Create the configuration settings from the request
        Configuration configuration = configurationParser.from(request);

        // Perform the upload process
        $File file = fileService.createFileHandler(fileRepository.getFileHandler())
                .upload(configuration, request.getResourcePath(), upload);

        return new ObjectDataResponse(fileService.createFileObject(file));
    }

    private FileDataRequest parseFileDataRequest(InputStream body) {
        try {
            return objectMapper.readValue(body, FileDataRequest.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to parse the incoming request as an file data request", e);
        }
    }

    private static InputStream getFileItemStream(FileItem item) {
        try {
            return item.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException("Unable to parse the incoming FileDataRequest", e);
        }
    }
}
