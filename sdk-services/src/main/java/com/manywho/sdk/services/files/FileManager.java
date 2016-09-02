package com.manywho.sdk.services.files;

import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.configuration.ConfigurationParser;
import com.manywho.sdk.services.types.system.$File;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.inject.Inject;
import java.io.IOException;

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

    public ObjectDataResponse uploadFile(MultipartFormDataInput multipartInput) throws IOException {
        // Get the first part that has a content type of "application/json", as it's probably the FileDataRequest
        FileDataRequest request = multipartInput.getParts().stream()
                .filter(bodyPart -> bodyPart.getMediaType().toString().contains("application/json"))
                .findFirst()
                .map(FileUploadService::getFileDataRequest)
                .orElseThrow(() -> new RuntimeException("No file metadata was sent in the request"));

        // Get the first part that doesn't have a content type of "application/json" as it's probably the file content
        FileUploadEntity uploadEntity = multipartInput.getParts().stream()
                .filter(bodyPart -> !bodyPart.getMediaType().toString().contains("application/json"))
                .findFirst()
                .map(FileUploadService::createFileUploadEntity)
                .orElseThrow(() -> new RuntimeException("No file was uploaded"));

        // Create the configuration values from the request
        Configuration configuration = configurationParser.from(request);

        // Perform the upload process
        $File file = fileService.createFileHandler(fileRepository.getFileHandler())
                .upload(configuration, request.getResourcePath(), uploadEntity);

        return new ObjectDataResponse(fileService.createFileObject(file));
    }
}
