package com.manywho.sdk.services;

import com.manywho.sdk.services.features.BodyReaderFeature;
import com.manywho.sdk.services.listeners.ReflectionListener;
import com.manywho.sdk.services.providers.ExceptionMapperProvider;
import com.manywho.sdk.services.providers.ObjectMapperProvider;
import com.manywho.sdk.services.providers.ValidationExceptionMapperProvider;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseApplication extends ResourceConfig {
    public ResourceConfig registerSdk() {
        return packages("com.manywho.sdk.services")
                .register(new ServiceBinder())
                .register(BodyReaderFeature.class)
                .register(ReflectionListener.class)
                .register(MultiPartFeature.class)
                .register(LoggingFilter.class)
                .register(ExceptionMapperProvider.class, 1)
                .register(ValidationExceptionMapperProvider.class, 1)
                .register(ObjectMapperProvider.class);
    }

    /**
     * Start the service using the built-in Grizzly container without a URL suffix
     *
     * @param application The application to start. It must extend {@link com.manywho.sdk.services.BaseApplication}.
     */
    public static void startServer(BaseApplication application) {
        startServer(application, "");
    }

    /**
     * Start the service using the built-in Grizzly container.
     *
     * @param application The application to start. It must extend {@link com.manywho.sdk.services.BaseApplication}.
     * @param suffix The URL suffix to append, e.g. "/api/name/1"
     */
    public static void startServer(BaseApplication application, String suffix) {
        try {
            // Load the desired port from a property, otherwise default to 8080
            final String port = System.getProperty("server.port") != null ? System.getProperty("server.port") : "8080";

            // Run on all interfaces
            final URI BASE_URI = URI.create(String.format("http://0.0.0.0:%s/%s", port, suffix));

            final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, application, false);

            Runtime.getRuntime().addShutdownHook(new Thread(server::shutdownNow));

            server.start();

            System.out.println(String.format("Service started.\nTry out %s\nStop the application using CTRL+C", BASE_URI));

            Thread.currentThread().join();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(application.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
}
