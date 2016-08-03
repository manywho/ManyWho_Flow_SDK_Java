package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.configuration.ConfigurationParser;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.Objects;
import java.util.Optional;

@Path("/file")
public class DefaultFileController extends AbstractFileController {

    private final ConfigurationParser configurationParser;

    @Inject
    public DefaultFileController(ConfigurationParser configurationParser) {
        this.configurationParser = configurationParser;
    }

    @Override
    public ObjectDataResponse uploadFile(MultipartFormDataInput multipartFormDataInput) throws Exception {

        Optional<InputPart> requestObject = multipartFormDataInput.getParts().stream()
                .filter(bodyPart -> Objects.equals(bodyPart.getMediaType().getType(), "application") && Objects.equals(bodyPart.getMediaType().getSubtype(), "json"))
                .findFirst();

        Optional<InputPart> requestFile  = multipartFormDataInput.getParts().stream()
                .filter(bodyPart -> !Objects.equals(bodyPart.getMediaType().getType(), "application") || !Objects.equals(bodyPart.getMediaType().getSubtype(), "json"))
                .findFirst();

        if(!requestObject.isPresent()) {
            throw new RuntimeException("Bad Request");
        }

        if(!requestFile.isPresent()) {
            throw new RuntimeException();
        }

        FileDataRequest fileDataRequest = requestObject.get().getBody(FileDataRequest.class, FileDataRequest.class);




        return uploadFile("", fileDataRequest, requestFile.get(), configurationParser.from(fileDataRequest));
    }

    public ObjectDataResponse uploadFile(String token, FileDataRequest fileDataRequest, InputPart inputPart, C from) {
        return null;
    }

}
