package com.manywho.services.example;

import com.github.javafaker.Faker;
import com.google.inject.AbstractModule;
import com.manywho.sdk.services.BaseApplication;

import javax.inject.Singleton;

public class Application extends BaseApplication {
    public static void main(String[] args) throws Exception {
        Application application = new Application();
        application.addModule(new AbstractModule() {
            @Override
            protected void configure() {
                bind(Faker.class).in(Singleton.class);
            }
        });
        application.startServer("api/example/1");
    }
}
