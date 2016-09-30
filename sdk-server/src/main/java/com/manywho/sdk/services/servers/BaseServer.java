package com.manywho.sdk.services.servers;

import com.google.common.collect.Lists;
import com.google.inject.Module;

import java.util.List;

public abstract class BaseServer implements Server {
    protected Class<?> application;
    protected List<Module> modules = Lists.newArrayList();

    @Override
    public void addModule(Module module) {
        modules.add(module);
    }

    public void setApplication(Class<?> application) {
        this.application = application;
    }
}
