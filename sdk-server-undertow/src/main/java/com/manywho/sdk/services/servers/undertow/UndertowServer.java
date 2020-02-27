package com.manywho.sdk.services.servers.undertow;

import java.io.IOException;
import java.io.InputStream;
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

    /**
     * Start a V2 instance of the service using the built-in Jetty container on a specified https port with client certificate authentication
     * 
     * @param path the path to run the service from
     * @param httpsPort the port to run the https service on
     * @param keyStore the keystore containing the server certificate
     * @param trustStore the truststore containing trusted certificates
     * @param keyStorePassword the password for the keystore
     * @param trustStorePassword the password for the truststore
     */
    public void start(String path, int httpsPort, InputStream keyStore, InputStream trustStore, String keyStorePassword, String trustStorePassword) {

        ServiceApplication serviceApplication = new ServiceApplication();

        for (Module module : modules) {
            serviceApplication.addModule(module);
        }

        serviceApplication.initialize(application.getPackage().getName(), true, true);

        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(buildKeyManagerFromStream(keyStore, keyStorePassword), buildTrustManagerFromStream(trustStore, trustStorePassword), null);

            Undertow.Builder serverBuilder = Undertow.builder()
                .addHttpsListener(httpsPort, "0.0.0.0", sslContext)
                .setSocketOption(Options.SSL_CLIENT_AUTH_MODE, SslClientAuthMode.REQUIRED);

            server = new UndertowJaxrsServer();
            server.start(serverBuilder);
            server.deploy(serviceApplication, path);

            LOGGER.info("Service started on https://0.0.0.0:{} - Client auth enabled", httpsPort);
            LOGGER.info("Stop the service using CTRL+C");
        } catch (Exception ex) {
            LOGGER.error("Unable to start the server", ex);
        }        
    }

    @Override
    public void stop() {
        if (server != null) {
            server.stop();
        }
    }

    private KeyManager[] buildKeyManagerFromStream(InputStream storeStream, String storePassword) throws NoSuchAlgorithmException, CertificateException, IOException, KeyStoreException, UnrecoverableKeyException {
        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(storeStream, storePassword.toCharArray());

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keystore, storePassword.toCharArray());

        KeyManager[] keyManager = keyManagerFactory.getKeyManagers();
        
        return keyManager;
    }

    private TrustManager[] buildTrustManagerFromStream(InputStream storeStream, String storePassword) throws NoSuchAlgorithmException, CertificateException, IOException, KeyStoreException {
        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(storeStream, storePassword.toCharArray());

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keystore);

        TrustManager[] trustManager = trustManagerFactory.getTrustManagers();
        
        return trustManager;
    }
}
