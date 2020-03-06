package com.manywho.sdk.services;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

import javax.ws.rs.core.Application;
import java.util.List;

public class ServerApplication extends Application {
    protected String packageName;
    protected Injector injector;

    protected List<Module> modules = Lists.newArrayList();

    public void addModule(Module module) {
        this.modules.add(module);
    }

    public void initialize(String packageName, boolean isHttp) {
        this.packageName = packageName;

        final List<Module> internalModules = Lists.newArrayList();

        internalModules.add(new ServerApplicationModule(packageName));

        if (this.modules == null) {
            injector = Guice.createInjector(internalModules);
        } else {
            injector = Guice.createInjector(Modules.override(internalModules).with(this.modules));
        }
    }
}
