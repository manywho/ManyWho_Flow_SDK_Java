package com.manywho.sdk.services.controllers;

import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public abstract class AbstractFileController implements FileController {
    @Path("/file/delete")
    @POST
    public abstract ObjectDataResponse deleteFile(FileDataRequest fileDataRequest) throws Exception;

    @Path("/file")
    @POST
    public abstract ObjectDataResponse loadFiles(FileDataRequest fileDataRequest) throws Exception;

    @POST
    @Path("/content")
    @Consumes({"multipart/form-data", "application/octet-stream"})
    public abstract ObjectDataResponse uploadFile(HttpServletRequest multipartInput) throws Exception;
}
