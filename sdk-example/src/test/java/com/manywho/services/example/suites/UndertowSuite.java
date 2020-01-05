package com.manywho.services.example.suites;

import com.manywho.sdk.api.jackson.ObjectMapperFactory;
import com.manywho.sdk.services.servers.undertow.UndertowServer;
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
public class UndertowSuite {
    private final static int PORT = 10000;

    private static UndertowServer server;

    @BeforeClass
    public static void beforeClass() {
        server = new UndertowServer();
        server.addModule(new ApplicationModule());
        server.setApplication(Application.class);
        server.start("/", PORT);

        RestAssured.config = RestAssuredConfig.newConfig();
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
