package com.manywho.sdk.api.draw.elements.type;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.draw.elements.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TypeElement extends Element {
    private String id;
    private String serviceElementId;
    protected List<TypeElementProperty> properties = new ArrayList<>();
    protected List<TypeElementBinding> bindings = new ArrayList<>();
    private boolean updateByName;

    public TypeElement() {
    }

    public TypeElement(String developerName, String developerSummary, List<TypeElementProperty> properties, List<TypeElementBinding> bindings) {
        this(developerName, properties, bindings);
        this.developerSummary = developerSummary;
    }

    public TypeElement(String developerName, List<TypeElementProperty> properties, List<TypeElementBinding> bindings) {
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

    public List<TypeElementProperty> getProperties() {
        return properties;
    }

    public void setProperties(List<TypeElementProperty> properties) {
        this.properties = properties;
    }

    public List<TypeElementBinding> getBindings() {
        return bindings;
    }

    public void setBindings(List<TypeElementBinding> bindings) {
        this.bindings = bindings;
    }

    public boolean isUpdateByName() {
        return updateByName;
    }

    public void setUpdateByName(boolean updateByName) {
        this.updateByName = updateByName;
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
            List<TypeElementProperty> typeElementProperties = properties.stream()
                    .map(property -> new TypeElementProperty(property.getDeveloperName(), property.getContentType(), property.getTypeName()))
                    .collect(Collectors.toList());

            List<TypeElementPropertyBinding> typeElementPropertyBindings = properties.stream()
                    .map(property -> new TypeElementPropertyBinding(property.getDeveloperName(), property.getFieldName()))
                    .collect(Collectors.toList());

            TypeElementBinding typeElementBinding = new TypeElementBinding();
            typeElementBinding.setDeveloperName(developerName);
            typeElementBinding.setDeveloperSummary("The binding for " + developerName);
            typeElementBinding.setDatabaseTableName(tableName);
            typeElementBinding.setPropertyBindings(typeElementPropertyBindings);

            List<TypeElementBinding> typeElementBindings = new ArrayList<>();
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
