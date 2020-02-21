package com.manywho.sdk.services.servers.undertow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import com.google.inject.Module;
import com.manywho.sdk.services.ServiceApplication;
import com.manywho.sdk.services.servers.BaseServer;
import com.manywho.sdk.services.servers.EmbeddedServer;
import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xnio.Options;
import org.xnio.SslClientAuthMode;

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
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(buildKeyManager(), buildTrustManager(), null);

            Undertow.Builder serverBuilder = Undertow.builder()
                    
                    .addHttpListener(port, "0.0.0.0")
                    .addHttpsListener(port+1, "0.0.0.0", sslContext)
                    .setSocketOption(Options.SSL_CLIENT_AUTH_MODE, SslClientAuthMode.REQUIRED);

            server = new UndertowJaxrsServer();
            server.start(serverBuilder);
            server.deploy(serviceApplication, path);

            LOGGER.info("Http Service started on 0.0.0.0:{}", port);
            LOGGER.info("Stop the service using CTRL+C");
        } catch (Exception ex) {
            LOGGER.error("Unable to start the server", ex);
        }
    }

    private KeyManager[] buildKeyManager() throws KeyStoreException, IOException, NoSuchAlgorithmException,
            CertificateException, FileNotFoundException, UnrecoverableKeyException {
                System.out.println(FileSystems.getDefault().getPath(".").toAbsolutePath().toString());
                char [] keyStorePassword = "secret".toCharArray();
        String keyStoreFilename = "src/main/resources/server_keystore.jks";

        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(new FileInputStream(keyStoreFilename), keyStorePassword);

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keystore, keyStorePassword);

        KeyManager[] keyManager = keyManagerFactory.getKeyManagers();
        return keyManager;
    }

    private TrustManager[] buildTrustManager() throws KeyStoreException, IOException, NoSuchAlgorithmException,
            CertificateException, FileNotFoundException, UnrecoverableKeyException {
        char [] trustStorePassword = "secret".toCharArray();
        String trustStoreFilename = "src/main/resources/server_truststore.jks";

        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(new FileInputStream(trustStoreFilename), trustStorePassword);

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keystore);

        TrustManager[] trustManager = trustManagerFactory.getTrustManagers();
        return trustManager;
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
