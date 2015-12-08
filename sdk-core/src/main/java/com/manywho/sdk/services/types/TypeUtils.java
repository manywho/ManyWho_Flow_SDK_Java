package com.manywho.sdk.services.types;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeUtils {
    public static Class<?> getGenericType(Type type) throws Exception {
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)type;

            return (Class<?>) parameterizedType.getActualTypeArguments()[0];
        }

        throw new Exception(String.format("The given type %s is not a generic type", type.getTypeName()));
    }
}
