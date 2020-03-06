package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.run.ServiceProblemException;
import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.services.files.FileManager;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/file")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DefaultFileController extends AbstractFileController {
    private final FileManager fileManager;
    private final FileUpload fileUpload;

    @Inject
    public DefaultFileController(FileManager fileManager, FileUpload fileUpload) {
        this.fileManager = fileManager;
        this.fileUpload = fileUpload;
    }

    @POST
    @Path("/delete")
    @Override
    public ObjectDataResponse deleteFile(FileDataRequest fileDataRequest) throws Exception {
        throw new ServiceProblemException(500, "Deleting files is not yet supported in the SDK");
    }

    @POST
    @Override
    public ObjectDataResponse loadFiles(FileDataRequest fileDataRequest) throws Exception {
        return fileManager.loadFiles(fileDataRequest);
    }

    @POST
    @Path("/content")
    @Consumes({"multipart/form-data", "application/octet-stream"})
    @Override
    public ObjectDataResponse uploadFile(@Context HttpServletRequest request) throws Exception {
        List<FileItem> files = fileUpload.parseRequest(new ServletRequestContext(request));

        return fileManager.uploadFile(files);
    }
}
