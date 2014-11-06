package com.manywho.sdk.services;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

public class BaseApplication {
    // @todo Try and make more efficient (even though it only occurs once, on startup)
    public static Reflections reflections = new Reflections(new ConfigurationBuilder()
            .addUrls(ClasspathHelper.forJavaClassPath())
            .addScanners(new MethodAnnotationsScanner())
    );
}
