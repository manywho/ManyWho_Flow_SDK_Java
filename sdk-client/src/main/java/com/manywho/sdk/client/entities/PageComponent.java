package com.manywho.sdk.client.entities;

import com.manywho.sdk.entities.run.elements.type.FileDataRequest;
import com.manywho.sdk.entities.run.elements.type.MObject;
import com.manywho.sdk.entities.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.enums.ContentType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageComponent {
    private String id;
    private String name;
    private String type;
    // TODO: Is this needed?
    private ContentType contentType;
    private int order;
    private Map<String, String> attributes = new HashMap<>();
    private Data data;

    public String getId() {
        return id;
    }

    public PageComponent setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PageComponent setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public PageComponent setType(String type) {
        this.type = type;
        return this;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public PageComponent setContentType(ContentType contentType) {
        this.contentType = contentType;
        return this;
    }

    public int getOrder() {
        return order;
    }

    public PageComponent setOrder(int order) {
        this.order = order;
        return this;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public PageComponent setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
        return this;
    }

    public Data getData() {
        return data;
    }

    public PageComponent setData(Data data) {
        this.data = data;
        return this;
    }

    public static class Data {
        private boolean enabled;
        private boolean editable;
        private boolean required;
        private boolean visible;
        private List<MObject> objectData;
        private ObjectDataRequest objectDataRequest;
        private FileDataRequest fileDataRequest;
        private String contentValue;
        private String content;

        public boolean isEnabled() {
            return enabled;
        }

        public Data setEnabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public boolean isEditable() {
            return editable;
        }

        public Data setEditable(boolean editable) {
            this.editable = editable;
            return this;
        }

        public boolean isRequired() {
            return required;
        }

        public Data setRequired(boolean required) {
            this.required = required;
            return this;
        }

        public boolean isVisible() {
            return visible;
        }

        public Data setVisible(boolean visible) {
            this.visible = visible;
            return this;
        }

        public List<MObject> getObjectData() {
            return objectData;
        }

        public Data setObjectData(List<MObject> objectData) {
            this.objectData = objectData;
            return this;
        }

        public ObjectDataRequest getObjectDataRequest() {
            return objectDataRequest;
        }

        public Data setObjectDataRequest(ObjectDataRequest objectDataRequest) {
            this.objectDataRequest = objectDataRequest;
            return this;
        }

        public FileDataRequest getFileDataRequest() {
            return fileDataRequest;
        }

        public Data setFileDataRequest(FileDataRequest fileDataRequest) {
            this.fileDataRequest = fileDataRequest;
            return this;
        }

        public String getContentValue() {
            return contentValue;
        }

        public Data setContentValue(String contentValue) {
            this.contentValue = contentValue;
            return this;
        }

        public String getContent() {
            return content;
        }

        public Data setContent(String content) {
            this.content = content;
            return this;
        }
    }
}
