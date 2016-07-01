package com.manywho.sdk.services.functional;

import com.google.inject.Injector;
import com.manywho.sdk.services.ServiceApplication;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class TestApplication extends ServiceApplication {
    public TestApplication(Injector injector) {
        super(injector);
    }
}
