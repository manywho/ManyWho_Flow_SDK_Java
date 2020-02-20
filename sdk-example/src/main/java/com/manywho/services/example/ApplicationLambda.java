package com.manywho.services.example;

import com.manywho.sdk.services.servers.lambda.LambdaServer;

public class ApplicationLambda extends LambdaServer {
    public ApplicationLambda() {
        this.addModule(new ApplicationModule());
        this.setApplication(ApplicationLambda.class);
        this.start();
    }
}
