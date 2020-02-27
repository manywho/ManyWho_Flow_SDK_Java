package com.manywho.sdk.services;

import org.jboss.resteasy.plugins.guice.ext.RequestScopeModule;
import org.reflections.Reflections;

import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ServiceApplication extends ServerApplication {
    protected boolean isV2;

    public void initialize(String packageName, boolean isHttp, boolean isV2) {
        this.isV2 = isV2;
        modules.add(new ServiceApplicationModule());

        if (isHttp) {
            modules.add(new RequestScopeModule());
        }

        super.initialize(packageName, isHttp);
    }

    @Override
    public Set<Object> getSingletons() {
        final Set<Object> objects = new HashSet<>();

        Reflections reflections = injector.getInstance(Reflections.class);

        // Filter the appropriate version specific controllers
        Set<Class<?>> controllers = 
            reflections.getTypesAnnotatedWith(Path.class).stream()
            .filter(c -> c.getName().endsWith(this.isV2 ? "V1" : "V2") == false).collect(Collectors.toSet());

        objects.addAll(createInstances(controllers));
        objects.addAll(createInstances(reflections.getTypesAnnotatedWith(Provider.class)));

        return objects;
    }

    private Set<Object> createInstances(Set<Class<?>> classes) {
        String servicePackage = this.packageName;

        // Only create instances of classes that are in the service or in the SDK
        return classes.stream()
                .filter(c -> c.getPackage().getName().startsWith(servicePackage) || c.getPackage().getName().startsWith("com.manywho.sdk.services"))
                .map(c -> injector.getInstance(c))
                .collect(Collectors.toSet());
    }
}
