package com.manywho.sdk.services.values;

import com.manywho.sdk.api.ContentType;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class ValueProperty {
    private ContentType contentType;
    private String content;
    private List<Map<String, ValueProperty>> objects;

    public ValueProperty(ContentType contentType, String content) {
        this.contentType = contentType;
        this.content = content;
    }

    public ValueProperty(ContentType contentType, List<Map<String, ValueProperty>> objects) {
        this.contentType = contentType;
        this.objects = objects;
    }

    public String getContent() {
        return content;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public List<Map<String, ValueProperty>> getObjects() {
        return objects;
    }

    public boolean hasContent() {
        return StringUtils.isNotEmpty(content);
    }

    public boolean hasObjects() {
        return CollectionUtils.isNotEmpty(objects);
    }
}
