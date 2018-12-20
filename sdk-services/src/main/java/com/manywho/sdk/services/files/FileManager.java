package com.manywho.sdk.services.files;

import com.manywho.sdk.api.run.ServiceProblemException;
import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.configuration.ConfigurationParser;
import com.manywho.sdk.services.types.system.$File;

import javax.inject.Inject;
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
        // Create the configuration settings from the request
        Configuration configuration = configurationParser.from(request);

        // Load the list of files from the service
        List<$File> files = fileService.createFileHandler(fileRepository.getFileHandler())
                .findAll(configuration, request.getListFilter(), request.getResourcePath());

        return new ObjectDataResponse(fileService.createFileObjects(files));
    }

    @SuppressWarnings("unchecked")
    public ObjectDataResponse uploadFile(FileDataRequest request, FileUpload upload) throws Exception {
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
}
