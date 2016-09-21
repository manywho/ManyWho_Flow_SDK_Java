package com.manywho.sdk.services;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import org.jboss.resteasy.plugins.guice.ext.RequestScopeModule;
import org.reflections.Reflections;
import ru.vyarus.guice.validator.ImplicitValidationModule;

import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.Provider;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ServiceApplication extends Application {
    protected Injector injector;

    protected List<Module> modules = Lists.newArrayList();

    public void addModule(Module module) {
        this.modules.add(module);
    }

    public void initialize(String packageName) {
        final List<Module> internalModules = Lists.newArrayList();

        internalModules.add(new ImplicitValidationModule());
        internalModules.add(new RequestScopeModule());
        internalModules.add(new ServiceApplicationModule(packageName));

        if (this.modules == null) {
            injector = Guice.createInjector(internalModules);
        } else {
            injector = Guice.createInjector(Modules.override(internalModules).with(this.modules));
        }
    }

    @Override
    public Set<Object> getSingletons() {
        final Set<Object> objects = new HashSet<>();

        Reflections reflections = injector.getInstance(Reflections.class);

        objects.addAll(createInstances(reflections.getTypesAnnotatedWith(Path.class)));
        objects.addAll(createInstances(reflections.getTypesAnnotatedWith(Provider.class)));

        return objects;
    }

    private Set<Object> createInstances(Set<Class<?>> classes) {
        String servicePackage = getClass().getPackage().getName();

        // Only create instances of classes that are in the service or in the SDK
        return classes.stream()
                .filter(c -> c.getPackage().getName().startsWith(servicePackage) || c.getPackage().getName().startsWith("com.manywho.sdk.services"))
                .map(c -> injector.getInstance(c))
                .collect(Collectors.toSet());
    }
}
