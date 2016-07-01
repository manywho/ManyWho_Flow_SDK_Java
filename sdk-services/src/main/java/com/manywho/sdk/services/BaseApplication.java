//package com.manywho.sdk.services;
//
//import com.google.common.collect.Lists;
//import com.google.inject.AbstractModule;
//import com.google.inject.Guice;
//import com.google.inject.Injector;
//import com.google.inject.Module;
//import com.google.inject.Scopes;
//import com.google.inject.servlet.ServletModule;
//import com.google.inject.util.Modules;
//import com.manywho.sdk.api.security.AuthenticatedWho;
//import com.manywho.sdk.services.configuration.ApplicationConfiguration;
//import com.manywho.sdk.services.jaxrs.mappers.DefaultExceptionMapper;
//import com.manywho.sdk.services.jaxrs.resolvers.ValidationConfigurationContextResolver;
//import com.manywho.sdk.services.providers.AuthenticatedWhoProvider;
//import com.manywho.sdk.services.providers.ReflectionsProvider;
//import com.manywho.sdk.services.providers.ServletContainerProvider;
//import com.manywho.sdk.services.types.DummyTypeProvider;
//import com.manywho.sdk.services.types.TypeProvider;
//import com.palominolabs.http.server.HttpServerConnectorConfig;
//import com.palominolabs.http.server.HttpServerWrapperConfig;
//import com.palominolabs.http.server.HttpServerWrapperFactory;
//import com.palominolabs.http.server.HttpServerWrapperModule;
//import com.squarespace.jersey2.guice.JerseyGuiceModule;
//import com.squarespace.jersey2.guice.JerseyGuiceUtils;
//import io.undertow.Undertow;
//import org.glassfish.hk2.api.ServiceLocator;
//import org.glassfish.hk2.extension.ServiceLocatorGenerator;
//import org.glassfish.jersey.filter.LoggingFilter;
//import org.glassfish.jersey.media.multipart.MultiPartFeature;
//import org.glassfish.jersey.server.ResourceConfig;
//import org.glassfish.jersey.server.ServerProperties;
//import org.glassfish.jersey.servlet.ServletContainer;
//import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
//import org.reflections.Reflections;
//import ru.vyarus.guice.validator.ImplicitValidationModule;
//import javax.ws.rs.core.Application;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class BaseApplication extends Application {
//    private final Injector injector;
//    private Module module;
//
//    public BaseApplication(final Injector injector) {
//        this.injector = injector;
//    }
//
//
//
////    public Set<Class<?>> getClasses() {
////        return Collections.emptySet();
////    }
//
//    public void initialize() {
////        packages(this.getClass().getSuperclass().getPackage().getName());
////        packages(this.getClass().getPackage().getName());
////        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
////        register(LoggingFilter.class);
////        register(MultiPartFeature.class);
////        register(ValidationConfigurationContextResolver.class);
//
////        registerClasses(DefaultExceptionMapper.class);
//
//        final String applicationPackage = this.getClass().getPackage().getName();
//
//        final List<Module> modules = Lists.newArrayList();
//        modules.add(new HttpServerWrapperModule());
//        modules.add(new ImplicitValidationModule());
//        modules.add(new ServletModule());
//        modules.add(new AbstractModule() {
//            @Override
//            protected void configure() {
//                bind(Reflections.class).toProvider(ReflectionsProvider.class).asEagerSingleton();
//                bind(ServletContainer.class).toProvider(ServletContainerProvider.class).in(Scopes.SINGLETON);
//                //bind(ResourceConfig.class).toInstance(BaseApplication.this);
//
//                bind(TypeProvider.class).to(DummyTypeProvider.class);
//
//                bind(ApplicationConfiguration.class).toInstance(new ApplicationConfiguration(applicationPackage));
//
//                install(new ServletModule() {
//                    @Override
//                    protected void configureServlets() {
//                        serve("/*").with(ServletContainer.class);
//                    }
//                });
//            }
//        });
//
////        if (module == null) {
////            injector = Guice.createInjector(modules);
////        } else {
////            injector = Guice.createInjector(Modules.override(modules).with(module));
////        }
//
//        JerseyGuiceUtils.install(new ServiceLocatorGenerator() {
//            @Override
//            public ServiceLocator create(String name, ServiceLocator parent) {
//                if (!name.startsWith("__HK2_Generated_")) {
//                    return null;
//                }
//
//                List<Module> modules = Lists.newArrayList();
//                modules.add(new JerseyGuiceModule(name));
//                modules.add(new AbstractModule() {
//                    @Override
//                    protected void configure() {
//                        if (injector.getBinding(AuthenticatedWho.class) == null) {
//                            bind(AuthenticatedWho.class).toProvider(AuthenticatedWhoProvider.class);
//                        }
//                    }
//                });
//
//                return injector.createChildInjector(modules).getInstance(ServiceLocator.class);
//            }
//        });
//    }
//
//    public void setModule(Module module) {
//        this.module = module;
//    }
//
//    /**
//     * Start the service using the built-in Jetty container on a specified port
//     *
//     * @param port the port to run the service on
//     */
//    public void startServer(int port) {
//        if (injector == null) {
//            initialize();
//        }
//
//        try {
//            UndertowJaxrsServer server = new UndertowJaxrsServer();
//            Undertow.Builder serverBuilder = Undertow.builder()
//                    .addHttpListener(8080, "0.0.0.0");
//
//            server.start(serverBuilder);
//            server.deploy(new BaseApplication(injector), "/api/sql/2");
////            HttpServerWrapperConfig config = new HttpServerWrapperConfig()
////                    .withHttpServerConnectorConfig(HttpServerConnectorConfig.forHttp("0.0.0.0", port));
////
////            injector.getInstance(HttpServerWrapperFactory.class)
////                    .getHttpServerWrapper(config)
////                    .start();
////
//            System.out.println(String.format("Service started on 0.0.0.0:%d.", port));
//            System.out.println("Stop the service using CTRL+C");
////
////            Thread.currentThread().join();
//        } catch (Exception ex) {
//            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    /**
//     * Start the service using the built-in Jetty container
//     */
//    public void startServer() throws Exception {
//        // Load the desired port from a property, otherwise default to 8080
//        final int port = System.getProperty("server.port") != null ? Integer.parseInt(System.getProperty("server.port")) : 8080;
//
//        startServer(port);
//    }
//}
