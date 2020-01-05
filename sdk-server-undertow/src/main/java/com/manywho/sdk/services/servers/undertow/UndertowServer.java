package com.manywho.sdk.services.servers.undertow;

import com.google.inject.Module;
import com.manywho.sdk.services.ServiceApplication;
import com.manywho.sdk.services.servers.BaseServer;
import com.manywho.sdk.services.servers.EmbeddedServer;
import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UndertowServer extends BaseServer implements EmbeddedServer {
    private static final Logger LOGGER = LoggerFactory.getLogger(UndertowServer.class);

    private UndertowJaxrsServer server;

    /**
     * Start the service using the built-in Jetty container on a specified port
     *
     * @param port the port to run the service on
     */
    public void start(String path, int port) {
        ServiceApplication serviceApplication = new ServiceApplication();

        for (Module module : modules) {
            serviceApplication.addModule(module);
        }

        serviceApplication.initialize(application.getPackage().getName(), true);

        try {
            Undertow.Builder serverBuilder = Undertow.builder()
                    .addHttpListener(port, "0.0.0.0");

            server = new UndertowJaxrsServer();
            server.start(serverBuilder);
            server.deploy(serviceApplication, path);

            LOGGER.info("Service started on 0.0.0.0:{}", port);
            LOGGER.info("Stop the service using CTRL+C");
        } catch (Exception ex) {
            LOGGER.error("Unable to start the server", ex);
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

    @Override
    public void stop() {
        if (server != null) {
            server.stop();
        }
    }
}
