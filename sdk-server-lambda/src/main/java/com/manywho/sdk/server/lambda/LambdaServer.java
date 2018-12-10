package com.manywho.sdk.server.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.api.run.elements.config.ListenerServiceRequest;
import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.server.lambda.model.HttpRequest;
import com.manywho.sdk.server.lambda.model.HttpResponse;
import com.manywho.sdk.services.ServerApplication;
import com.manywho.sdk.services.database.DatabaseManager;
import com.manywho.sdk.services.database.DatabaseType;
import com.manywho.sdk.services.describe.DescribeManager;
import com.manywho.sdk.services.files.FileManager;
import com.manywho.sdk.services.listeners.ListenerManager;
import com.manywho.sdk.services.servers.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class LambdaServer extends ServerApplication implements RequestStreamHandler, Server {
    private static final Logger LOGGER = LoggerFactory.getLogger(LambdaServer.class);

    private ObjectMapper objectMapper;

    private Class<?> application;

    public void setApplication(Class<?> application) {
        this.application = application;
    }

    public void start() {
        this.initialize(application.getPackage().getName(), true);

        objectMapper = injector.getInstance(ObjectMapper.class);
    }

    @Override
    public void stop() {

    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        LOGGER.info("Handling request at the top: {}", context.getAwsRequestId());

        HttpRequest httpRequest = objectMapper
                .readValue(inputStream, HttpRequest.class);

        Object response;
        try {
            response = routeRequest(httpRequest);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        // TODO: Handle errors

        int status = response == null
                ? 204
                : 200;

        HttpResponse httpResponse = new HttpResponse();
        httpResponse.setBody(objectMapper.writeValueAsString(response));
        httpResponse.setHeaders(headers);
        httpResponse.setStatusCode(status);

        objectMapper.writeValue(outputStream, httpResponse);
    }

    // TODO: Extract
    Object routeRequest(HttpRequest httpRequest) throws Exception {
        Object response;

        switch (httpRequest.getHttpMethod()) {
            case "PUT":
                switch (httpRequest.getPath()) {
                    case "/data":
                        response = injector.getInstance(DatabaseManager.class)
                                .handle(DatabaseType.Save, parseObjectDataRequest(httpRequest.getBody()));
                        break;
                    default:
                        // TODO: Throw a 404?
                        throw new RuntimeException("An unsupported request was encountered");
                }

                break;
            case "POST":
                if (httpRequest.getPath().startsWith("/actions")) {
                    // TODO
                    response = null;
                    break;
                }

                switch (httpRequest.getPath()) {
                    case "/authentication":
                        // TODO
                        response = null;
                        break;
                    case "/authorization":
                        // TODO
                        response = null;
                        break;
                    case "/authorization/group":
                        // TODO
                        response = null;
                        break;
                    case "/authorization/group/attribute":
                        // TODO
                        response = null;
                        break;
                    case "/authorization/user":
                        // TODO
                        response = null;
                        break;
                    case "/authorization/user/attribute":
                        // TODO
                        response = null;
                        break;
                    case "/data":
                        response = injector.getInstance(DatabaseManager.class)
                                .handle(DatabaseType.Load, parseObjectDataRequest(httpRequest.getBody()));
                        break;
                    case "/data/delete":
                        response = injector.getInstance(DatabaseManager.class)
                                .handle(DatabaseType.Delete, parseObjectDataRequest(httpRequest.getBody()));
                        break;
                    case "/file/content":
//                        response = injector.getInstance(DefaultFileController.class)
//                                .uploadFile();

                        // TODO
                        response = null;
                        break;
                    case "/file/delete":
                        // TODO
                        throw new UnsupportedOperationException("Deleting files is not yet supported in the SDK");
                    case "/file/file":
                        response = injector.getInstance(FileManager.class)
                                .loadFiles(parseFileDataRequest(httpRequest.getBody()));
                        break;
                    case "/listener":
                        injector.getInstance(ListenerManager.class)
                                .create(parseListenerRequest(httpRequest.getBody()));

                        response = null;

                        break;
                    case "/metadata":
                        response = injector.getInstance(DescribeManager.class)
                                .describe(parseDescribeRequest(httpRequest.getBody()));
                        break;
                    default:
                        // TODO
                        throw new RuntimeException();
                }

                break;
            default:
                // TODO
                throw new RuntimeException();
        }

        return response;
    }

    DescribeServiceRequest parseDescribeRequest(String body) {
        try {
            return objectMapper.readValue(body, DescribeServiceRequest.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to parse the incoming request as an describe request", e);
        }
    }

    FileDataRequest parseFileDataRequest(String body) {
        try {
            return objectMapper.readValue(body, FileDataRequest.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to parse the incoming request as an file data request", e);
        }
    }

    ListenerServiceRequest parseListenerRequest(String body) {
        try {
            return objectMapper.readValue(body, ListenerServiceRequest.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to parse the incoming request as an listener request", e);
        }
    }

    ObjectDataRequest parseObjectDataRequest(String body) {
        try {
            return objectMapper.readValue(body, ObjectDataRequest.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to parse the incoming request as an object data request", e);
        }
    }
}
