package com.manywho.services.example.suites;

import com.manywho.sdk.api.jackson.ObjectMapperFactory;
import com.manywho.sdk.services.lambda.LambdaHttpClient;
import com.manywho.sdk.services.servers.lambda.LambdaServer;
import com.manywho.services.example.Application;
import com.manywho.services.example.ApplicationModule;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.extensions.cpsuite.ClasspathSuite;
import org.junit.runner.RunWith;

@RunWith(ClasspathSuite.class)
public class LambdaSuite {
    private static LambdaServer server;

    @BeforeClass
    public static void beforeClass() throws Exception {
        server = new LambdaServer();
        server.addModule(new ApplicationModule());
        server.setApplication(Application.class);
        server.start();

        ObjectMapperConfig config = new ObjectMapperConfig()
                .jackson2ObjectMapperFactory((type, s) -> ObjectMapperFactory.create());

        RestAssured.config = RestAssuredConfig.config()
                .objectMapperConfig(config)
                .httpClient(
                        RestAssured.config()
                                .getHttpClientConfig()
                                .httpClientFactory(() -> new LambdaHttpClient(server.getDispatcher()))
                );

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @AfterClass
    public static void afterClass() {
        server.stop();
    }
}
