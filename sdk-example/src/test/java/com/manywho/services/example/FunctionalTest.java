package com.manywho.services.example;

import com.manywho.sdk.services.servers.undertow.UndertowServer;
import io.restassured.RestAssured;
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
    }

    @AfterClass
    public static void afterClass() {
        server.stop();
    }
}
