package com.manywho.services.example;

import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.api.describe.DescribeServiceResponse;
import com.manywho.sdk.api.jackson.ObjectMapperFactory;
import com.manywho.sdk.server.lambda.LambdaServer;
import org.junit.Test;

import java.io.*;

public class DescribeTestLambda {
    @Test
    public void testDescribe() throws IOException {
        InputStream request;
        {
            ByteArrayOutputStream requestOutputStream = new ByteArrayOutputStream();

            PipedOutputStream out = new PipedOutputStream();

            try {
                request = new PipedInputStream(out);
                requestOutputStream.writeTo(out);

                ObjectMapperFactory.create().writeValue(requestOutputStream, new DescribeServiceRequest());
            } catch (Exception e) {
                // TODO
                throw new RuntimeException(e);
            }
        }

        OutputStream responseStream = new ByteArrayOutputStream();
        {

        }

        new LambdaServer().handleRequest(request, responseStream, null);

        DescribeServiceResponse response;
        {
            ByteArrayOutputStream responseOutputStream = new ByteArrayOutputStream();

            PipedOutputStream out = new PipedOutputStream();

            try {
                InputStream responseInputStream = new PipedInputStream(out);
                responseOutputStream.writeTo(out);

                response = ObjectMapperFactory.create().readValue(responseInputStream, DescribeServiceResponse.class);
            } catch (Exception e) {
                // TODO
                throw new RuntimeException(e);
            }
        }
    }
}
