package com.manywho.sdk.services.values;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.services.types.Type;
import com.manywho.sdk.services.types.TypeBuilder;

import javax.inject.Inject;
import java.util.Collection;

public class ValueBuilder {
    private final TypeBuilder typeBuilder;

    @Inject
    public ValueBuilder(TypeBuilder typeBuilder) {
        this.typeBuilder = typeBuilder;
    }

    /**
     * Create a Value with a given name and content type from an object. ContentList and ContentObject values are
     * automatically converted into correctly-formed MObjects.
     *
     * @param name           the name of the Value to create
     * @param contentType    the content type of the Value to create
     * @param object         the object to be contained in the Value
     * @return a populated Value
     */
    public EngineValue from(String name, ContentType contentType, Object object) {
        switch (contentType) {
            case List:
                return new EngineValue(name, contentType, typeBuilder.from((Collection<? extends Type>) object));
            case Object:
                return new EngineValue(name, contentType, typeBuilder.from((Type) object));
            default:
                return new EngineValue(name, contentType, object);
        }
    }
}
