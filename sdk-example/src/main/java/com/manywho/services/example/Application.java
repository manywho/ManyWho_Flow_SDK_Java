package com.manywho.services.example;

import com.manywho.sdk.services.BaseApplication;

public class Application extends BaseApplication {
    public static void main(String[] args) throws Exception {
        Application application = new Application();
        application.startServer("api/example/1");
    }
}
