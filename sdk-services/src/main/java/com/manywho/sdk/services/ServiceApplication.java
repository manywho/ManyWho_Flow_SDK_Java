package com.manywho.sdk.services;

import com.google.common.collect.Lists;
import com.google.inject.*;
//import com.google.inject.servlet.ServletModule;
import com.manywho.sdk.services.configuration.ApplicationConfiguration;
import com.manywho.sdk.services.providers.ReflectionsProvider;
//import com.manywho.sdk.services.providers.ServletContainerProvider;
import com.manywho.sdk.services.types.DummyTypeProvider;
import com.manywho.sdk.services.types.TypeProvider;
import com.palominolabs.http.server.HttpServerWrapperModule;
//import org.glassfish.jersey.servlet.ServletContainer;
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


    public ServiceApplication() {
    }

    public void initialize(String applicationPackage) {
        final List<Module> modules = Lists.newArrayList();
        modules.add(new HttpServerWrapperModule());
        modules.add(new ImplicitValidationModule());
//        modules.add(new ServletModule());
        modules.add(new AbstractModule() {
            @Override
            protected void configure() {
                bind(Reflections.class).toProvider(ReflectionsProvider.class).asEagerSingleton();
//                bind(ServletContainer.class).toProvider(ServletContainerProvider.class).in(Scopes.SINGLETON);
                //bind(ResourceConfig.class).toInstance(BaseApplication.this);

                bind(TypeProvider.class).to(DummyTypeProvider.class);
                bind(ApplicationConfiguration.class).toInstance(new ApplicationConfiguration(applicationPackage));
//                install(new ServletModule() {
//                    @Override
//                    protected void configureServlets() {
//                        serve("/*").with(ServletContainer.class);
//                    }
//                });
            }
        });

        this.injector = Guice.createInjector(modules);
    }

//    @Override
//    public Set<Class<?>> getClasses() {
//        final Set<Class<?>> classes = new HashSet<>();
//        return classes;
//    }

    @Override
    public Set<Object> getSingletons() {
        final Set<Object> objects = new HashSet<>();
        Reflections reflections = getReflections(this.getClass().getPackage().getName());
        Reflections reflections2 = getReflections("com.manywho.sdk.services");

        addToObjects(objects, reflections.getTypesAnnotatedWith(Path.class));
        addToObjects(objects, reflections.getTypesAnnotatedWith(Provider.class));
        addToObjects(objects, reflections2.getTypesAnnotatedWith(Path.class));
        addToObjects(objects, reflections2.getTypesAnnotatedWith(Provider.class));

        return objects;
    }

    protected void addToObjects(Set<Object> objects, Set<Class<?>> classes) {
        objects.addAll(classes.stream().map(c -> injector.getInstance(c)).collect(Collectors.toSet()));
    }

    protected Reflections getReflections(String packageName) {
        ApplicationConfiguration applicationConfiguration = new ApplicationConfiguration(packageName);
        ReflectionsProvider reflectionsProvider = new ReflectionsProvider(applicationConfiguration);
        return reflectionsProvider.get();
    }

}
