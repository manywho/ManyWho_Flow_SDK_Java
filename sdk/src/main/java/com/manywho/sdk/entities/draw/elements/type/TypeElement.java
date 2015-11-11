package com.manywho.sdk.entities.draw.elements.type;

import com.manywho.sdk.entities.draw.elements.Element;
import com.manywho.sdk.enums.ContentType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TypeElement extends Element implements Comparable<TypeElement> {
    private String id;
    private String serviceElementId;
    protected TypeElementPropertyCollection properties = new TypeElementPropertyCollection();
    protected TypeElementBindingCollection bindings = new TypeElementBindingCollection();
    private boolean updateByName;

    public TypeElement() {
    }

    public TypeElement(String developerName, String developerSummary, TypeElementPropertyCollection properties, TypeElementBindingCollection bindings) {
        this(developerName, properties, bindings);
        this.developerSummary = developerSummary;
    }

    public TypeElement(String developerName, TypeElementPropertyCollection properties, TypeElementBindingCollection bindings) {
        this.developerName = developerName;
        this.properties = properties;
        this.bindings = bindings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceElementId() {
        return serviceElementId;
    }

    public void setServiceElementId(String serviceElementId) {
        this.serviceElementId = serviceElementId;
    }

    public TypeElementPropertyCollection getProperties() {
        return properties;
    }

    public void setProperties(TypeElementPropertyCollection properties) {
        this.properties = properties;
    }

    public TypeElementBindingCollection getBindings() {
        return bindings;
    }

    public void setBindings(TypeElementBindingCollection bindings) {
        this.bindings = bindings;
    }

    public boolean isUpdateByName() {
        return updateByName;
    }

    public void setUpdateByName(boolean updateByName) {
        this.updateByName = updateByName;
    }

    @Override
    public int compareTo(TypeElement o) {
        return this.getDeveloperName().compareTo(o.getDeveloperName());
    }

    public static class SimpleTypeBuilder {
        private String developerName;
        private String tableName;
        private List<TypeProperty> properties = new ArrayList<>();

        public SimpleTypeBuilder setDeveloperName(String developerName) {
            this.developerName = developerName;
            return this;
        }

        public SimpleTypeBuilder setTableName(String tableName) {
            this.tableName = tableName;
            return this;
        }

        public SimpleTypeBuilder addProperty(String developerName, ContentType contentType, String fieldName) {
            properties.add(new TypeProperty(developerName, contentType, fieldName));
            return this;
        }

        public SimpleTypeBuilder addProperty(String developerName, ContentType contentType, String typeName, String fieldName) {
            properties.add(new TypeProperty(developerName, contentType, typeName, fieldName));
            return this;
        }

        public TypeElement build() {
            TypeElementPropertyCollection typeElementProperties = properties.stream()
                    .map(property -> new TypeElementProperty(property.getDeveloperName(), property.getContentType(), property.getTypeName()))
                    .collect(Collectors.toCollection(TypeElementPropertyCollection::new));

            TypeElementPropertyBindingCollection typeElementPropertyBindings = properties.stream()
                    .map(property -> new TypeElementPropertyBinding(property.getDeveloperName(), property.getFieldName()))
                    .collect(Collectors.toCollection(TypeElementPropertyBindingCollection::new));

            TypeElementBinding typeElementBinding = new TypeElementBinding();
            typeElementBinding.setDeveloperName(developerName);
            typeElementBinding.setDeveloperSummary("The binding for " + developerName);
            typeElementBinding.setDatabaseTableName(tableName);
            typeElementBinding.setPropertyBindings(typeElementPropertyBindings);

            TypeElementBindingCollection typeElementBindings = new TypeElementBindingCollection();
            typeElementBindings.add(typeElementBinding);

            return new TypeElement(developerName, typeElementProperties, typeElementBindings);
        }

        class TypeProperty {
            private final String developerName;
            private final ContentType contentType;
            private final String typeName;
            private final String fieldName;

            public TypeProperty(String developerName, ContentType contentType, String fieldName) {
                this(developerName, contentType, null, fieldName);
            }

            public TypeProperty(String developerName, ContentType contentType, String typeName, String fieldName) {
                this.developerName = developerName;
                this.contentType = contentType;
                this.typeName = typeName;
                this.fieldName = fieldName;
            }

            public String getDeveloperName() {
                return developerName;
            }

            public ContentType getContentType() {
                return contentType;
            }

            public String getTypeName() {
                return typeName;
            }

            public String getFieldName() {
                return fieldName;
            }

            public class TypePropertyBuilder {
                private String developerName;
                private ContentType contentType;
                private String typeName;
                private String fieldName;

                public TypePropertyBuilder setDeveloperName(String developerName) {
                    this.developerName = developerName;
                    return this;
                }

                public TypePropertyBuilder setContentType(ContentType contentType) {
                    this.contentType = contentType;
                    return this;
                }

                public TypePropertyBuilder setTypeName(String typeName) {
                    this.typeName = typeName;
                    return this;
                }

                public TypePropertyBuilder setFieldName(String fieldName) {
                    this.fieldName = fieldName;
                    return this;
                }

                public TypeProperty build() {
                    return new TypeProperty(developerName, contentType, typeName, fieldName);
                }
            }
        }
    }
}
