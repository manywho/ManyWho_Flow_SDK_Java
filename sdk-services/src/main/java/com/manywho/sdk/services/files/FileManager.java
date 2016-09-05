package com.manywho.sdk.services.files;

import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.configuration.ConfigurationParser;
import com.manywho.sdk.services.types.system.$File;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

public class FileManager {
    private final ConfigurationParser configurationParser;
    private final FileRepository fileRepository;
    private final FileService fileService;

    @Inject
    public FileManager(ConfigurationParser configurationParser, FileRepository fileRepository, FileService fileService) {
        this.configurationParser = configurationParser;
        this.fileRepository = fileRepository;
        this.fileService = fileService;
    }

    @SuppressWarnings("unchecked")
    public ObjectDataResponse loadFiles(FileDataRequest request) {
        // Create the configuration values from the request
        Configuration configuration = configurationParser.from(request);

        // Load the list of files from the service
        List<$File> files = fileService.createFileHandler(fileRepository.getFileHandler())
                .findAll(configuration, request.getListFilter(), request.getResourcePath());

        return new ObjectDataResponse(fileService.createFileObjects(files));
    }

    @SuppressWarnings("unchecked")
    public ObjectDataResponse uploadFile(MultipartFormDataInput multipartInput) throws IOException {
        // Get the first part that has a content type of "application/json", as it's probably the FileDataRequest
        FileDataRequest request = multipartInput.getParts().stream()
                .filter(bodyPart -> bodyPart.getMediaType().toString().contains("application/json"))
                .findFirst()
                .map(FileUploadService::getFileDataRequest)
                .orElseThrow(() -> new RuntimeException("No file metadata was sent in the request"));

        // Get the first part that doesn't have a content type of "application/json" as it's probably the file content
        FileUpload upload = multipartInput.getParts().stream()
                .filter(bodyPart -> !bodyPart.getMediaType().toString().contains("application/json"))
                .findFirst()
                .map(FileUploadService::createFileUpload)
                .orElseThrow(() -> new RuntimeException("No file was uploaded"));

        // Create the configuration values from the request
        Configuration configuration = configurationParser.from(request);

        // Perform the upload process
        $File file = fileService.createFileHandler(fileRepository.getFileHandler())
                .upload(configuration, request.getResourcePath(), upload);

        return new ObjectDataResponse(fileService.createFileObject(file));
    }
}
