package com.manywho.sdk.services.controllers;

import com.manywho.sdk.entities.run.elements.type.FileDataRequest;
import com.manywho.sdk.entities.run.elements.type.ObjectDataResponse;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

public abstract class AbstractFileController extends AbstractController {

    @Path("/file")
    @POST
    public abstract ObjectDataResponse loadFiles(FileDataRequest fileDataRequest) throws Exception;

    @POST
    @Path("/file/content")
    @Consumes({"multipart/form-data","application/octet-stream"})
    public abstract ObjectDataResponse uploadFile(FormDataMultiPart multiPart) throws Exception;

    @Path("/file/delete")
    @POST
    public abstract ObjectDataResponse deleteFile(FileDataRequest fileDataRequest) throws Exception;
}
