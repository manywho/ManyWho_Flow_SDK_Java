package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public abstract class AbstractFileController {

    @Path("/file")
    @POST
    public abstract ObjectDataResponse loadFiles(FileDataRequest fileDataRequest) throws Exception;

    @POST
    @Path("/file/content")
    @Consumes({"multipart/form-data", "application/octet-stream"})
    public abstract ObjectDataResponse uploadFile(
            @FormDataParam("FileDataRequest") FileDataRequest fileDataRequest,
            @FormDataParam("file") FormDataContentDisposition fileInformation,
            @FormDataParam("file") InputStream file) throws Exception;

    @Path("/file/delete")
    @POST
    public abstract ObjectDataResponse deleteFile(FileDataRequest fileDataRequest) throws Exception;
}
