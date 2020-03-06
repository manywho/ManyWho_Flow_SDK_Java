package com.manywho.sdk.services.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fields {
    public static List<Field> fromType(Class<?> type) {
        List<Field> typeFields = new ArrayList<Field>();

        // Get a list of all the fields, and the inherited fields
        Class<?> i = type;
        while (i != null && i != Object.class) {
            Collections.addAll(typeFields, i.getDeclaredFields());
            i = i.getSuperclass();
        }

        return typeFields;
    }
}
