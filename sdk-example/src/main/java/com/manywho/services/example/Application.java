package com.manywho.services.example;

import com.manywho.sdk.services.BaseApplication;

public class Application extends BaseApplication {
    public static void main(String[] args) throws Exception {
        Application application = new Application();
        application.setModule(new ApplicationModule());
        application.startServer();
    }
}
