package com.manywho.sdk.services.types;

import com.manywho.sdk.services.annotations.TypeProperty;

import java.lang.reflect.Field;

class TypePropertyFieldTuple {
    private final TypeProperty typeProperty;
    private final Field field;

    public TypePropertyFieldTuple(TypeProperty typeProperty, Field field) {
        this.typeProperty = typeProperty;
        this.field = field;
    }

    public TypeProperty getTypeProperty() {
        return typeProperty;
    }

    public Field getField() {
        return field;
    }
}
