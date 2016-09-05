package com.manywho.sdk.services.files;

import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;

import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.io.InputStream;

public class FileUploadService {

    public static FileUploadEntity createFileUploadEntity(InputPart part) {
        return new FileUploadEntity(getFileContent(part), getFilename(part.getHeaders()));
    }

    public static FileDataRequest getFileDataRequest(InputPart part) {
        try {
            return part.getBody(FileDataRequest.class, FileDataRequest.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to parse the incoming FileDataRequest", e);
        }
    }

    private static InputStream getFileContent(InputPart part) {
        try {
            return part.getBody(InputStream.class, InputStream.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to parse the incoming file content", e);
        }
    }

    private static String getFilename(MultivaluedMap<String, String> headers) {
        String contentDispositionHeader = headers.getFirst("Content-Disposition");

        if (contentDispositionHeader == null) {
            throw new RuntimeException("No Content-Disposition header could be found on the request");
        }

        // Get the name provided for the incoming file
        for (String name : contentDispositionHeader.split(";")) {
            if (name.trim().startsWith("filename")) {
                return name.split("=")[1].trim().replaceAll("\"", "");
            }
        }

        return "unknown";
    }
}
