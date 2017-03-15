package com.manywho.sdk.services.servers;

public interface EmbeddedServer extends Server {
    void start(String path) throws Exception;
    void start(String path, int port) throws Exception;
}
