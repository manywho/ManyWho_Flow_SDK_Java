package com.manywho.sdk.services.servers.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manywho.sdk.api.run.ServiceProblem;
import com.manywho.sdk.api.run.ServiceProblemException;
import com.manywho.sdk.services.servers.lambda.model.ApiGatewayHttpRequest;
import com.manywho.sdk.services.servers.lambda.model.ApiGatewayHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LambdaDispatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(LambdaDispatcher.class);

    private final ObjectMapper objectMapper;
    private final LambdaRouter router;

    @Inject
    public LambdaDispatcher(ObjectMapper objectMapper, LambdaRouter router) {
        this.objectMapper = objectMapper;
        this.router = router;
    }

    public ApiGatewayHttpResponse dispatch(ApiGatewayHttpRequest httpRequest, Context context) throws IOException {
        LOGGER.info("Handling request at the top: {}", context.getAwsRequestId());

        Object response;
        int status;

        try {
            response = router.routeRequest(httpRequest);

            status = response == null
                    ? 204
                    : 200;
        } catch (ServiceProblemException e) {
            // TODO
            response = new ServiceProblem(httpRequest.getPath(), e.getStatusCode(), e.getMessage());
            status = e.getStatusCode();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        // TODO: Handle errors

        ApiGatewayHttpResponse httpResponse = new ApiGatewayHttpResponse();
        httpResponse.setBody(objectMapper.writeValueAsString(response));
        httpResponse.setHeaders(headers);
        httpResponse.setStatusCode(status);

        return httpResponse;
    }
}
