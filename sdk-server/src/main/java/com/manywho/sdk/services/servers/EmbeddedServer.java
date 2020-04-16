package com.manywho.sdk.services.servers;

import java.io.InputStream;

public interface EmbeddedServer extends Server {
    void start(String path) throws Exception;
    void start(String path, int port) throws Exception;
    void start(String path, int httpsPort, InputStream keyStore, InputStream trustStore, String keyStorePassword, String trustStorePassword) throws Exception;
}
