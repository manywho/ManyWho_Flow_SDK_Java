package com.manywho.services.example;

import com.manywho.sdk.services.servers.lambda.LambdaServer;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class ApplicationLambda extends LambdaServer {
    public ApplicationLambda() {
        this.addModule(new ApplicationModule());
        this.setApplication(ApplicationLambda.class);
        this.start();
    }
}
