package com.manywho.sdk.services.servers.undertow;

import com.manywho.sdk.services.ServiceApplication;
import com.manywho.sdk.services.servers.BaseServer;
import com.manywho.sdk.services.servers.EmbeddedServer;
import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UndertowServer extends BaseServer implements EmbeddedServer {

    /**
     * Start the service using the built-in Jetty container on a specified port
     *
     * @param port the port to run the service on
     */
    public void start(String path, int port) {
        ServiceApplication serviceApplication = new ServiceApplication();
        serviceApplication.initialize(application.getPackage().getName());

        try {
            UndertowJaxrsServer server = new UndertowJaxrsServer();
            Undertow.Builder serverBuilder = Undertow.builder()
                    .addHttpListener(port, "0.0.0.0");

            server.start(serverBuilder);
            server.deploy(serviceApplication, path);

            System.out.println(String.format("Service started on 0.0.0.0:%d.", port));
            System.out.println("Stop the service using CTRL+C");
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Start the service using the build-in Jetty container from a specified path
     *
     * @param path the path to run the service from
     * @throws Exception
     */
    public void start(String path) throws Exception {
        // Load the desired port from a property, otherwise default to 8080
        final int port = System.getProperty("server.port") != null ? Integer.parseInt(System.getProperty("server.port")) : 8080;

        start(path, port);
    }

    /**
     * Start the service using the built-in Jetty container
     */
    public void start() throws Exception {
        start("/");
    }
}
