package com.manywho.sdk.services.servers;

import com.google.inject.Module;

public interface Server {
    void addModule(Module module);

    void setApplication(Class<?> application);

    void start() throws Exception;

    void stop();
}
