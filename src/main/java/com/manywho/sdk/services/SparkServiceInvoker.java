package com.manywho.sdk.services;

import com.manywho.sdk.entities.ResponseInterface;
import com.manywho.sdk.entities.ServiceRequest;
import com.manywho.sdk.services.annotations.Invoke;
import spark.Request;

import java.lang.reflect.Method;
import java.util.Set;

public class SparkServiceInvoker extends AbstractService {
    private Request request;

    public SparkServiceInvoker(Request request) {
        this.request = request;
    }

    public ResponseInterface invoke() {
        String requestMethod = this.request.requestMethod();
        String uriPart = this.request.pathInfo();

        Set<Method> invokeMethods = BaseApplication.reflections.getMethodsAnnotatedWith(Invoke.class);

        for (Method method : invokeMethods) {
            // @todo This block is still pretty slow - it should be sped up
            Invoke annotation = method.getAnnotation(Invoke.class);

            if (uriPart.endsWith(annotation.path())) {
                // Check to see if the method's class has an Invoke annotation (containing the URL)
                if (method.getDeclaringClass().isAnnotationPresent(Invoke.class)) {
                    String parentPath = method.getDeclaringClass().getAnnotation(Invoke.class).path();

                    // Check to see if the current URL begins with the annotation's path value
                    if (uriPart.startsWith(parentPath)) {
                        uriPart = uriPart.replace(parentPath + "/", "");
                    }

                    if (annotation.method().equals(requestMethod) && annotation.path().equals(uriPart)) {
                        try {
                            return (ResponseInterface) method.invoke(method.getDeclaringClass().newInstance(), this.convertToRequest(this.request.body(), ServiceRequest.class));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        return null;
    }
}
