package com.manywho.services.example.types;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.describe.DescribeServiceRequest;
import com.manywho.sdk.api.draw.elements.type.TypeElement;
import com.manywho.sdk.api.draw.elements.type.TypeElementBinding;
import com.manywho.sdk.api.draw.elements.type.TypeElementProperty;
import com.manywho.sdk.api.draw.elements.type.TypeElementPropertyBinding;
import com.manywho.sdk.services.types.TypeProvider;

import java.util.List;

public class RawTypeProvider implements TypeProvider {
    @Override
    public boolean doesTypeExist(String name) {
        return name.equals("custom-type-one");
    }

    @Override
    public List<TypeElement> describeTypes(DescribeServiceRequest request) {
        List<TypeElementProperty> properties = Lists.newArrayList();
        properties.add(new TypeElementProperty("Property One", ContentType.String));
        properties.add(new TypeElementProperty("Property Two", ContentType.String));

        List<TypeElementPropertyBinding> propertyBindings = Lists.newArrayList();
        propertyBindings.add(new TypeElementPropertyBinding("Property One", "property-one"));
        propertyBindings.add(new TypeElementPropertyBinding("Property Two", "property-two"));

        List<TypeElementBinding> bindings = Lists.newArrayList();
        bindings.add(new TypeElementBinding("Custom Type One", "The binding for Custom Type One", "custom-type-one", propertyBindings));

        TypeElement customTypeOne = new TypeElement("Custom Type One", properties, bindings);

        return Lists.newArrayList(customTypeOne);
    }
}
