package com.manywho.sdk.services.servers;

import com.google.common.collect.Lists;
import com.google.inject.Module;
import com.manywho.sdk.services.ServiceApplication;

import java.util.List;

public class Servlet3Server extends ServiceApplication implements Server {
    private Class<?> application;
    private List<Module> modules = Lists.newArrayList();

    @Override
    public void addModule(Module module) {
        modules.add(module);
    }

    public void setApplication(Class<?> application) {
        this.application = application;
    }

    public void start() {
        this.initialize(application.getPackage().getName());
    }
}
