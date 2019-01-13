package com.manywho.sdk.services.servers.lambda;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.api.run.ServiceProblemException;
import com.manywho.sdk.api.run.elements.config.ListenerServiceRequest;
import com.manywho.sdk.api.run.elements.config.ServiceRequest;
import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.services.actions.ActionManager;
import com.manywho.sdk.services.database.DatabaseManager;
import com.manywho.sdk.services.database.DatabaseType;
import com.manywho.sdk.services.describe.DescribeManager;
import com.manywho.sdk.services.files.FileManager;
import com.manywho.sdk.services.listeners.ListenerManager;
import com.manywho.sdk.services.servers.lambda.model.ApiGatewayHttpRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class LambdaRouter {
    private final static Logger LOGGER = LoggerFactory.getLogger(LambdaRouter.class);

    private final ObjectMapper objectMapper;
    private final ActionManager actionManager;
    private final DatabaseManager databaseManager;
    private final DescribeManager describeManager;
    private final FileManager fileManager;
    private final FileUpload fileUpload;
    private final ListenerManager listenerManager;

    @Inject
    public LambdaRouter(ObjectMapper objectMapper, ActionManager actionManager, DatabaseManager databaseManager, DescribeManager describeManager, FileManager fileManager, FileUpload fileUpload, ListenerManager listenerManager) {
        this.objectMapper = objectMapper;
        this.actionManager = actionManager;
        this.databaseManager = databaseManager;
        this.describeManager = describeManager;
        this.fileManager = fileManager;
        this.fileUpload = fileUpload;
        this.listenerManager = listenerManager;
    }

    public Object routeRequest(ApiGatewayHttpRequest httpRequest) {
        LOGGER.info("Routing a {} request to the path {}", httpRequest.getHttpMethod(), httpRequest.getPath());

        switch (httpRequest.getHttpMethod()) {
            case "PUT":
                return routePut(httpRequest.getPath(), httpRequest.getBody());
            case "POST":
                return routePost(httpRequest.getPath(), httpRequest.getBody(), httpRequest.getHeaders());
            default:
                throw new ServiceProblemException(400, "No action could be found at the given location");
        }
    }

    private Object routePost(String path, String body, Map<String, String> headers) {
        if (path.startsWith("/actions")) {
            String actionPath = path.substring(9);

            return actionManager.executeAction(actionPath, parseServiceRequest(body));
        }

        switch (path) {
            case "/authentication":
            case "/authorization":
            case "/authorization/group":
            case "/authorization/group/attribute":
            case "/authorization/user":
            case "/authorization/user/attribute":
                throw new ServiceProblemException(500, "Identity is not yet supported using the SDK lambda handler");
            case "/data":
                return databaseManager.handle(DatabaseType.Load, parseObjectDataRequest(body));
            case "/data/delete":
                return databaseManager.handle(DatabaseType.Delete, parseObjectDataRequest(body));
            case "/file/content":
                ByteArrayInputStream bodyStream = new ByteArrayInputStream(Base64.getDecoder().decode(body));

                List<FileItem> files;

                try {
                    files = fileUpload.parseRequest(new LambdaRequestContext(bodyStream, headers));
                } catch (FileUploadException e) {
                    LOGGER.error("Unable to process the uploaded file content", e);

                    throw new ServiceProblemException(500, "Unable to process the uploaded file content");
                }

                return fileManager.uploadFile(files);
            case "/file/delete":
                throw new ServiceProblemException(500, "Deleting files is not yet supported in the SDK");
            case "/file":
                return fileManager.loadFiles(parseFileDataRequest(body));
            case "/listener":
                listenerManager.create(parseListenerRequest(body));

                return null;
            case "/metadata":
                return describeManager.describe(parseDescribeRequest(body));
            default:
                throw new ServiceProblemException(400, "No action could be found at the given location");
        }
    }

    private Object routePut(String path, String body) {
        switch (path) {
            case "/data":
                return databaseManager.handle(DatabaseType.Save, parseObjectDataRequest(body));
            default:
                // TODO: Throw a 404?
                throw new RuntimeException("An unsupported request was encountered");
        }
    }

    private DescribeServiceRequest parseDescribeRequest(String body) {
        try {
            return objectMapper.readValue(body, DescribeServiceRequest.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to parse the incoming request as an describe request", e);
        }
    }

    private FileDataRequest parseFileDataRequest(String body) {
        try {
            return objectMapper.readValue(body, FileDataRequest.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to parse the incoming request as an file data request", e);
        }
    }

    private ListenerServiceRequest parseListenerRequest(String body) {
        try {
            return objectMapper.readValue(body, ListenerServiceRequest.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to parse the incoming request as an listener request", e);
        }
    }

    private ObjectDataRequest parseObjectDataRequest(String body) {
        try {
            return objectMapper.readValue(body, ObjectDataRequest.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to parse the incoming request as an object data request", e);
        }
    }

    private ServiceRequest parseServiceRequest(String body) {
        try {
            return objectMapper.readValue(body, ServiceRequest.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to parse the incoming request as a service request", e);
        }
    }
}
