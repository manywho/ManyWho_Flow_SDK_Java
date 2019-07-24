package com.manywho.services.example;

import com.manywho.sdk.api.jackson.ObjectMapperFactory;
import com.manywho.sdk.services.servers.undertow.UndertowServer;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class FunctionalTest {
    private final static int PORT = 10000;

    private static UndertowServer server;

    @BeforeClass
    public static void beforeClass() {
        server = new UndertowServer();
        server.addModule(new ApplicationModule());
        server.setApplication(Application.class);
        server.start("/", PORT);

        RestAssured.port = PORT;
        ObjectMapperConfig config = new ObjectMapperConfig()
                .jackson2ObjectMapperFactory((type, s) -> ObjectMapperFactory.create());

        RestAssured.config = RestAssuredConfig.config().objectMapperConfig(config);
    }

    @AfterClass
    public static void afterClass() {
        server.stop();
    }
}
