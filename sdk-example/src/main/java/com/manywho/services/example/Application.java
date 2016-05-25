package com.manywho.services.example;

import com.github.javafaker.Faker;
import com.google.inject.AbstractModule;
import com.manywho.sdk.services.BaseApplication;
import com.manywho.sdk.services.types.TypeProvider;
import com.manywho.services.example.types.RawTypeProvider;

import javax.inject.Singleton;

public class Application extends BaseApplication {
    public static void main(String[] args) throws Exception {
        Application application = new Application();
        application.setModule(new AbstractModule() {
            @Override
            protected void configure() {
                bind(Faker.class).in(Singleton.class);
                bind(TypeProvider.class).to(RawTypeProvider.class);
            }
        });
        application.startServer("api/example/1");
    }
}
