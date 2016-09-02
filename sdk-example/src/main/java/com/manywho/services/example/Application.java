package com.manywho.services.example;

import com.manywho.sdk.services.ServiceApplication;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class Application extends ServiceApplication {
    public Application() {
        this.initialize();
    }

    public static void main(String[] args) throws Exception {
        Application service = new Application();
        service.setModule(new ApplicationModule());
        service.startServer();
    }
}
