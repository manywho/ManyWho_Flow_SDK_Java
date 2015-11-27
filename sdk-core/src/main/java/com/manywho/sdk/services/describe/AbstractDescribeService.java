package com.manywho.sdk.services.describe;

import com.github.fge.lambdas.Throwing;
import com.manywho.sdk.entities.describe.DescribeServiceInstall;
import com.manywho.sdk.entities.describe.DescribeServiceResponse;
import com.manywho.sdk.entities.draw.elements.type.TypeElementBinding;
import com.manywho.sdk.entities.draw.elements.type.TypeElementBindingCollection;
import com.manywho.sdk.entities.draw.elements.type.TypeElementCollection;
import com.manywho.sdk.entities.draw.elements.type.TypeElementProperty;
import com.manywho.sdk.entities.draw.elements.type.TypeElementPropertyBinding;
import com.manywho.sdk.entities.draw.elements.type.TypeElementPropertyBindingCollection;
import com.manywho.sdk.entities.draw.elements.type.TypeElementPropertyCollection;
import com.manywho.sdk.enums.ContentType;
import com.manywho.sdk.services.CachedData;
import com.manywho.sdk.services.annotations.TypeElement;
import com.manywho.sdk.services.annotations.TypeProperty;
import com.manywho.sdk.services.describe.actions.AbstractAction;
import com.manywho.sdk.services.describe.actions.ActionCollection;
import com.manywho.sdk.services.describe.types.AbstractType;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractDescribeService implements DescribeService {
    @Override
    public boolean getProvidesAutoBinding() {
        return false;
    }

    @Override
    public boolean getProvidesDatabase() {
        return false;
    }

    @Override
    public boolean getProvidesFiles() {
        return false;
    }

    @Override
    public boolean getProvidesIdentity() {
        return false;
    }

    @Override
    public boolean getProvidesListening() {
        return false;
    }

    @Override
    public boolean getProvidesLogic() {
        return false;
    }

    @Override
    public boolean getProvidesNotifications() {
        return false;
    }

    @Override
    public boolean getProvidesSmartSave() {
        return false;
    }

    @Override
    public boolean getProvidesSocial() {
        return false;
    }

    @Override
    public boolean getProvidesSharing() {
        return false;
    }

    @Override
    public boolean getProvidesViews() {
        return false;
    }

    @Override
    public boolean getProvidesVoting() {
        return false;
    }

    @Override
    public ActionCollection createActions() throws IllegalAccessException, InstantiationException {
        ActionCollection actions = CachedData.reflections.getSubTypesOf(AbstractAction.class).stream()
                .map(Throwing.function(Class::newInstance))
                .collect(Collectors.toCollection(ActionCollection::new));

        Collections.sort(actions);

        return actions;
    }

    @Override
    public DescribeServiceInstall createInstall() throws IllegalAccessException, InstantiationException {
        TypeElementCollection typeElements = new TypeElementCollection();
        typeElements.addAll(buildTypeElementsFromAbstractTypes());
        typeElements.addAll(buildTypeElementsFromAnnotatedTypes());

        Collections.sort(typeElements);

        return new DescribeServiceInstall(typeElements);
    }

    @Override
    public DescribeServiceResponse createResponse() throws Exception {
        return new DescribeServiceResponse() {{
            setCulture(AbstractDescribeService.this.createCulture());
            setConfigurationValues(AbstractDescribeService.this.createConfigurationValues());
            setProvidesAutoBinding(AbstractDescribeService.this.getProvidesAutoBinding());
            setProvidesDatabase(AbstractDescribeService.this.getProvidesDatabase());
            setProvidesFiles(AbstractDescribeService.this.getProvidesFiles());
            setProvidesIdentity(AbstractDescribeService.this.getProvidesIdentity());
            setProvidesListening(AbstractDescribeService.this.getProvidesListening());
            setProvidesLogic(AbstractDescribeService.this.getProvidesLogic());
            setProvidesNotifications(AbstractDescribeService.this.getProvidesNotifications());
            setProvidesSmartSave(AbstractDescribeService.this.getProvidesSmartSave());
            setProvidesSocial(AbstractDescribeService.this.getProvidesSocial());
            setProvidesSharing(AbstractDescribeService.this.getProvidesSharing());
            setProvidesViews(AbstractDescribeService.this.getProvidesViews());
            setProvidesVoting(AbstractDescribeService.this.getProvidesVoting());
            setActions(AbstractDescribeService.this.createActions());
            setInstall(AbstractDescribeService.this.createInstall());
        }};
    }

    private TypeElementCollection buildTypeElementsFromAbstractTypes() {
        final Set<Class<? extends AbstractType>> types = CachedData.reflections
                .getSubTypesOf(AbstractType.class);

        // Loop over all the classes that extend AbstractType, instantiate, then add them into a TypeElementCollection
        if (CollectionUtils.isNotEmpty(types)) {
            return types.stream()
                    .map(Throwing.function(type -> (com.manywho.sdk.entities.draw.elements.type.TypeElement) type.newInstance()))
                    .collect(Collectors.toCollection(TypeElementCollection::new));
        }

        return new TypeElementCollection();
    }

    private TypeElementCollection buildTypeElementsFromAnnotatedTypes() {
        final Set<Class<?>> types = CachedData.reflections.getTypesAnnotatedWith(TypeElement.class);

        if (CollectionUtils.isNotEmpty(types)) {
            final Set<Field> annotatedProperties = CachedData.reflections.getFieldsAnnotatedWith(TypeProperty.class);

            return types.stream()
                    .map(type -> buildTypeElementFromAnnotatedType(type, annotatedProperties))
                    .collect(Collectors.toCollection(TypeElementCollection::new));
        }

        return new TypeElementCollection();
    }

    private com.manywho.sdk.entities.draw.elements.type.TypeElement buildTypeElementFromAnnotatedType(Class<?> annotatedType, Set<Field> annotatedProperties) {
        TypeElement typeElement = annotatedType.getAnnotation(TypeElement.class);

        // Build a list of ManyWho Properties created from the annotated fields in the type passed in
        TypeElementPropertyCollection properties = annotatedProperties.stream()
                .filter(field -> field.getDeclaringClass().equals(annotatedType))
                .map(field -> field.getAnnotation(TypeProperty.class))
                .map(Throwing.function(this::createTypeElementProperty))
                .sorted()
                .collect(Collectors.toCollection(TypeElementPropertyCollection::new));

        TypeElementPropertyBindingCollection propertyBindings = annotatedProperties.stream()
                .filter(field -> field.getDeclaringClass().equals(annotatedType))
                .map(field -> field.getAnnotation(TypeProperty.class))
                .filter(TypeProperty::bound)
                .map(property -> new TypeElementPropertyBinding(property.name(), property.name()))
                .sorted()
                .collect(Collectors.toCollection(TypeElementPropertyBindingCollection::new));

        TypeElementBindingCollection bindings = new TypeElementBindingCollection();
        bindings.add(new TypeElementBinding(typeElement.name(), typeElement.summary(), typeElement.name(), propertyBindings));

        return new com.manywho.sdk.entities.draw.elements.type.TypeElement(typeElement.name(), typeElement.summary(), properties, bindings);
    }

    /**
     * @param property the #{@link TypeProperty} to create a new #{@link TypeElementProperty} from
     * @return a new property containing the values from the given annotations
     * @throws Exception when a referenced type could not be found
     */
    private TypeElementProperty createTypeElementProperty(TypeProperty property) throws Exception {
        String referencedTypeName = null;

        // If the type property annotation is of Object or List, then we need to find the name of the referenced type
        if (property.contentType().equals(ContentType.Object) || property.contentType().equals(ContentType.List)) {
            referencedTypeName = this.getReferencedTypeName(property.referencedType());
        }

        // Return a new TypeElementProperty with the values from annotations
        return new TypeElementProperty(property.name(), property.contentType(), referencedTypeName);
    }

    /**
     * @param aClass the class on which to check for a #{@link TypeElement} annotation
     * @return the developer name of the Type the property is referencing
     * @throws Exception when a referenced type could not be found
     */
    private String getReferencedTypeName(Class<?> aClass) throws Exception {
        if (!aClass.isAnnotationPresent(TypeElement.class)) {
            throw new Exception("The referenced type " + aClass.getTypeName() + " is not annotated with @TypeElement");
        }

        return aClass.getAnnotation(TypeElement.class).name();
    }
}
