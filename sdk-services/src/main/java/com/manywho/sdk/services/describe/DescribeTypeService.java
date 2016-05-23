package com.manywho.sdk.services.describe;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.draw.elements.type.TypeElement;
import com.manywho.sdk.api.draw.elements.type.TypeElementBinding;
import com.manywho.sdk.api.draw.elements.type.TypeElementProperty;
import com.manywho.sdk.api.draw.elements.type.TypeElementPropertyBinding;
import com.manywho.sdk.services.types.Type;
import com.manywho.sdk.services.types.TypeHasNoPropertiesException;
import com.manywho.sdk.services.types.TypeIdentifierMissingException;
import com.manywho.sdk.services.types.TypeParser;
import com.manywho.sdk.services.types.TypeRepository;
import org.apache.commons.collections4.CollectionUtils;

import javax.inject.Inject;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DescribeTypeService {
    private final TypeRepository typeRepository;

    @Inject
    public DescribeTypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<TypeElement> createTypes() {
        final Set<Class<? extends Type>> types = typeRepository.getTypeElements();

        if (types.isEmpty()) {
            return Lists.newArrayList();
        }

        // Create the types, excluding any that are included in the SDK
        return types.stream()
                .filter(type -> !type.getPackage().getName().startsWith("com.manywho.sdk.services.types.system"))
                .map(this::createTypeElement)
                .collect(Collectors.toList());
    }

    private TypeElement createTypeElement(Class<? extends Type> type) {
        if (!type.isAnnotationPresent(Type.Element.class)) {
            throw new RuntimeException("The type " + type.getName() + " must be annotated with " + Type.Element.class.getCanonicalName());
        }

        Type.Element annotation = type.getAnnotation(Type.Element.class);

        // Check if we have an identifier property on the type
        long identifierCount = typeRepository.getTypeIdentifiers().stream()
                .filter(field -> field.getDeclaringClass().equals(type))
                .filter(field -> String.class.isAssignableFrom(field.getType()))
                .count();

        if (identifierCount != 1) {
            throw new TypeIdentifierMissingException(type);
        }
        
        // Build the list of properties from the annotated type
        List<TypeElementProperty> properties = typeRepository.getTypeProperties().stream()
                .filter(field -> field.getDeclaringClass().equals(type))
                .map(this::createTypeElementProperty)
                .sorted()
                .collect(Collectors.toList());

        if (properties.isEmpty()) {
            throw new TypeHasNoPropertiesException(annotation);
        }

        // Build the property bindings
        List<TypeElementPropertyBinding> propertyBindings = typeRepository.getTypeProperties().stream()
                .filter(field -> field.getDeclaringClass().equals(type))
                .map(field -> field.getAnnotation(Type.Property.class))
                .filter(Type.Property::bound)
                .map(this::createTypeElementPropertyBinding)
                .sorted()
                .collect(Collectors.toList());

        // Create the default summary value if one wasn't defined
        String summary = annotation.summary();
        if (summary.isEmpty()) {
            summary = "The " + annotation.name() + " object structure";
        }

        // Create the binding list, and add a single binding if we have any bound properties
        List<TypeElementBinding> bindings = Lists.newArrayList();
        if (CollectionUtils.isNotEmpty(propertyBindings)) {
            bindings.add(new TypeElementBinding(annotation.name(), summary, annotation.name(), propertyBindings));
        }

        return new TypeElement(annotation.name(), summary, properties, bindings);
    }

    private TypeElementProperty createTypeElementProperty(Field field) {
        Type.Property annotation = field.getAnnotation(Type.Property.class);

        String referencedTypeName = null;

        // If the type property annotation is of type Object or List, then we need to find the typeElementName of the referenced type
        if (annotation.contentType().equals(ContentType.Object) || annotation.contentType().equals(ContentType.List)) {
            referencedTypeName = TypeParser.getReferencedTypeName(field, annotation.contentType());
        }

        return new TypeElementProperty(annotation.name(), annotation.contentType(), referencedTypeName);
    }

    private TypeElementPropertyBinding createTypeElementPropertyBinding(Type.Property property) {
        return new TypeElementPropertyBinding(property.name(), property.name());
    }
}
