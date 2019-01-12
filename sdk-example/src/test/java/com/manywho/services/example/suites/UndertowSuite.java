package com.manywho.services.example.suites;

import com.manywho.sdk.services.servers.undertow.UndertowServer;
import com.manywho.services.example.Application;
import com.manywho.services.example.ApplicationModule;
import io.restassured.RestAssured;
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

        RestAssured.port = PORT;
    }

    @AfterClass
    public static void afterClass() {
        server.stop();
    }
}
