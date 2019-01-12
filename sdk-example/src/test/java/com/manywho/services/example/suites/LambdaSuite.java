package com.manywho.services.example.suites;

import com.manywho.sdk.services.servers.lambda.LambdaServer;
import com.manywho.services.example.Application;
import com.manywho.services.example.ApplicationModule;
import io.restassured.RestAssured;
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

        RestAssured.config = RestAssuredConfig.config()
                .httpClient(
                        RestAssured.config()
                                .getHttpClientConfig()
                                .httpClientFactory(() -> new LambdaHttpClient(server))
                );
    }

    @AfterClass
    public static void afterClass() {
        server.stop();
    }
}
