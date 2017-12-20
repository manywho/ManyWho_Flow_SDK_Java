package com.manywho.sdk.api.run.elements.ui;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.manywho.sdk.api.ContentType;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Builder
@Data
public class PageComponentResponse {
    private String pageContainerDeveloperName;
    private UUID pageContainerId;
    private UUID id;
    private String developerName;
    private String componentType;
    private ContentType contentType;
    private String label;
    @Builder.Default
    private List<PageComponentColumnResponse> columns = Lists.newArrayList();
    private int size;
    private int maxSize;
    private int height;
    private int width;
    private String hintValue;
    private String helpInfo;
    private int order;
    @JsonProperty("isMultiSelect")
    private boolean multiSelect;
    @JsonProperty("isSearchable")
    private boolean searchable;
    private boolean hasEvents;
    @Builder.Default
    private Map<String, String> attributes = Maps.newHashMap();
}
