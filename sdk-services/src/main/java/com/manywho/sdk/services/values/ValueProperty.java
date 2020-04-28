package com.manywho.sdk.services.values;

import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.ContentType;

import java.util.List;
import java.util.Map;

public class ValueProperty {
    private ContentType contentType;
    private String content;
    private List<Map<String, ValueProperty>> objects = Lists.newArrayList();

    public ValueProperty(ContentType contentType, String content) {
        this.contentType = contentType;
        this.content = content;
    }

    public ValueProperty(ContentType contentType, List<Map<String, ValueProperty>> objects) {
        this.contentType = contentType;
        this.objects = MoreObjects.firstNonNull(objects, Lists.newArrayList());
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
        return !Strings.isNullOrEmpty(content);
    }

    public boolean hasObjects() {
        return !objects.isEmpty();
    }
}
