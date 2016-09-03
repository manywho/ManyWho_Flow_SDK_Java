package com.manywho.sdk.services.servers;

public interface EmbeddedServer extends Server {
    void start() throws Exception;
    void start(String path, int port) throws Exception;
}
