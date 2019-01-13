package com.manywho.services.example.suites;

import com.manywho.sdk.services.servers.lambda.LambdaDispatcher;
import com.manywho.sdk.services.servers.lambda.model.ApiGatewayHttpRequest;
import com.manywho.sdk.services.servers.lambda.model.ApiGatewayHttpResponse;
import org.apache.http.*;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.execchain.PublicHttpResponseProxy;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

/**
 * This class is used to "mock" the HTTP communication to and from a Lambda handler, which is useful for running API
 * tests using something like Rest Assured without having to spin up an actual Lambda function and API Gateway instance.
 */
public class LambdaHttpClient extends AbstractHttpClient {
    private final LambdaDispatcher dispatcher;

    public LambdaHttpClient(LambdaDispatcher dispatcher) {
        super(null, null);

        this.dispatcher = dispatcher;
    }

    @Override
    public CloseableHttpResponse execute(HttpUriRequest request) throws IOException {
        return doExecute(request);
    }

    @Override
    public CloseableHttpResponse execute(HttpUriRequest request, HttpContext context) throws IOException {
        return doExecute(request);
    }

    @Override
    public CloseableHttpResponse execute(HttpHost target, HttpRequest request) throws IOException {
        return doExecute(request);
    }

    @Override
    public CloseableHttpResponse execute(HttpHost target, HttpRequest request, HttpContext context) throws IOException {
        return doExecute(request);
    }

    @Override
    public <T> T execute(HttpUriRequest request, ResponseHandler<? extends T> responseHandler) throws IOException {
        return responseHandler.handleResponse(doExecute(request));
    }

    @Override
    public <T> T execute(HttpUriRequest request, ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException {
        return responseHandler.handleResponse(doExecute(request));
    }

    @Override
    public <T> T execute(HttpHost target, HttpRequest request, ResponseHandler<? extends T> responseHandler) throws IOException {
        return responseHandler.handleResponse(doExecute(request));
    }

    @Override
    public <T> T execute(HttpHost target, HttpRequest request, ResponseHandler<? extends T> responseHandler, HttpContext context) throws IOException {
        return responseHandler.handleResponse(doExecute(request));
    }

    @Override
    protected HttpParams createHttpParams() {
        return new BasicHttpParams();
    }

    @Override
    protected BasicHttpProcessor createHttpProcessor() {
        return new BasicHttpProcessor();
    }

    /**
     * This method basically translates the HttpClient request into an API Gateway HTTP request, and sends it straight
     * into the Lambda handler directly.
     *
     * @param request
     * @return
     * @throws IOException
     */
    private CloseableHttpResponse doExecute(HttpRequest request) throws IOException {
        ApiGatewayHttpRequest gatewayRequest = new ApiGatewayHttpRequest();

        // If we're given a request with a body, then let's try and extract it to send through to the handler
        if (request instanceof HttpEntityEnclosingRequest) {
            HttpEntityEnclosingRequest entityRequest = (HttpEntityEnclosingRequest) request;

            if (entityRequest.getEntity() != null) {
                String contentType = entityRequest.getEntity().getContentType().getValue();

                gatewayRequest.getHeaders().put("Content-Type", contentType);

                // The body content needs to be serialized into a content-specific format, before sending to the handler
                if (contentType.startsWith("application/json")) {
                    gatewayRequest.setBody(convertBodyToString(entityRequest));
                    gatewayRequest.setBase64Encoded(false);
                } else if (contentType.startsWith("application/octet-stream") || contentType.startsWith("multipart")) {
                    gatewayRequest.setBody(convertBodyToBase64(entityRequest));
                    gatewayRequest.setBase64Encoded(true);
                } else {
                    throw new RuntimeException("An unsupported content type of " + contentType + " was given");
                }
            }
        }

        gatewayRequest.setHttpMethod(request.getRequestLine().getMethod());
        gatewayRequest.setPath(URI.create(request.getRequestLine().getUri()).getPath());

        for (Header header : request.getAllHeaders()) {
            gatewayRequest.getHeaders().put(header.getName(), header.getValue());
        }

        ApiGatewayHttpResponse gatewayResponse = dispatcher.dispatch(gatewayRequest, new LambdaFakeContext());

        HttpResponse response = new BasicHttpResponse(request.getProtocolVersion(), gatewayResponse.getStatusCode(), "");
        response.setEntity(new StringEntity(gatewayResponse.getBody(), StandardCharsets.UTF_8));
        response.setStatusCode(gatewayResponse.getStatusCode());

        for (Map.Entry<String, String> header : gatewayResponse.getHeaders().entrySet()) {
            response.addHeader(header.getKey(), header.getValue());
        }

        return new PublicHttpResponseProxy(response);
    }

    private static String convertBodyToBase64(HttpEntityEnclosingRequest request) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        request.getEntity().writeTo(outputStream);

        return Base64.getEncoder().encodeToString(outputStream.toByteArray());
    }

    private static String convertBodyToString(HttpEntityEnclosingRequest request) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        request.getEntity().writeTo(outputStream);

        return outputStream.toString(StandardCharsets.UTF_8.name());
    }
}
