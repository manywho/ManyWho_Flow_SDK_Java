package com.manywho.sdk.services;

import org.glassfish.jersey.server.ResourceConfig;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

public class BaseApplication extends ResourceConfig {
    // @todo Try and make more efficient (even though it only occurs once, on startup)
    public static Reflections reflections;
}
