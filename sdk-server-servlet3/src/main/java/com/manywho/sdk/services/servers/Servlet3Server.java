package com.manywho.sdk.services.servers;

import com.manywho.sdk.services.ServiceApplication;

public class Servlet3Server extends ServiceApplication implements Server {
    private Class<?> application;

    public void setApplication(Class<?> application) {
        this.application = application;
    }

    public void start() {
        this.initialize(application.getPackage().getName(), true, false);
    }

    @Override
    public void stop() {

    }
}
