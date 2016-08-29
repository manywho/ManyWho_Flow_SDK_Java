package com.manywho.sdk.services;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import io.undertow.Undertow;
import org.jboss.resteasy.plugins.guice.ext.RequestScopeModule;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.reflections.Reflections;
import ru.vyarus.guice.validator.ImplicitValidationModule;

import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.Provider;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ServiceApplication extends Application {
    protected Injector injector;

    protected Module module;

    public ServiceApplication() {

    }

    public ServiceApplication(Injector injector) {
        this.injector = injector;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public void initialize() {
        final List<Module> modules = Lists.newArrayList();

        modules.add(new ImplicitValidationModule());
        modules.add(new RequestScopeModule());
        modules.add(new ServiceApplicationModule(this.getClass().getPackage().getName()));

        if (module == null) {
            injector = Guice.createInjector(modules);
        } else {
            injector = Guice.createInjector(Modules.override(modules).with(module));
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

    /**
     * Start the service using the built-in Jetty container on a specified port
     *
     * @param port the port to run the service on
     */
    public void startServer(String path, int port) {
        if (injector == null) {
            initialize();
        }

        try {
            UndertowJaxrsServer server = new UndertowJaxrsServer();
            Undertow.Builder serverBuilder = Undertow.builder()
                    .addHttpListener(port, "0.0.0.0");

            server.start(serverBuilder);
            server.deploy(this, path);

            System.out.println(String.format("Service started on 0.0.0.0:%d.", port));
            System.out.println("Stop the service using CTRL+C");
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Start the service using the build-in Jetty container from a specified path
     *
     * @param path the path to run the service from
     * @throws Exception
     */
    public void startServer(String path) throws Exception {
        // Load the desired port from a property, otherwise default to 8080
        final int port = System.getProperty("server.port") != null ? Integer.parseInt(System.getProperty("server.port")) : 8080;

        startServer(path, port);
    }

    /**
     * Start the service using the built-in Jetty container
     */
    public void startServer() throws Exception {
        startServer("/");
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
