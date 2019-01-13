package com.manywho.sdk.services.servers.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.services.ServerApplication;
import com.manywho.sdk.services.servers.Server;
import com.manywho.sdk.services.servers.lambda.model.ApiGatewayHttpRequest;
import com.manywho.sdk.services.servers.lambda.model.ApiGatewayHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LambdaServer extends ServerApplication implements RequestStreamHandler, Server {
    private static final Logger LOGGER = LoggerFactory.getLogger(LambdaServer.class);

    private ObjectMapper objectMapper;
    private LambdaDispatcher dispatcher;

    private Class<?> application;

    public void setApplication(Class<?> application) {
        this.application = application;
    }

    public void start() {
        this.initialize(application.getPackage().getName(), true);

        objectMapper = injector.getInstance(ObjectMapper.class);
        dispatcher = injector.getInstance(LambdaDispatcher.class);
    }

    @Override
    public void stop() {

    }

    // TODO: Remove the need for this by allowing an injector to be passed into the SDK, instead of the SDK creating it
    public LambdaDispatcher getDispatcher() {
        return dispatcher;
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        ApiGatewayHttpRequest httpRequest = objectMapper
                .readValue(inputStream, ApiGatewayHttpRequest.class);

        ApiGatewayHttpResponse httpResponse = dispatcher.dispatch(httpRequest, context);

        objectMapper.writeValue(outputStream, httpResponse);
    }
}
