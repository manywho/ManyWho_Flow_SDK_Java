package com.manywho.sdk.api.run.elements.ui;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.run.EngineValue;
import com.manywho.sdk.api.run.PropertyAware;
import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import com.manywho.sdk.api.run.elements.type.MObject;
import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Builder
@Data
public class PageComponentDataResponse implements PropertyAware {
    private UUID pageComponentId;
    @JsonProperty("isEnabled")
    private boolean enabled;
    @JsonProperty("isEditable")
    private boolean editable;
    @JsonProperty("isRequired")
    private boolean required;
    @JsonProperty("isVisible")
    private boolean visible;
    @Builder.Default
    private List<MObject> objectData = Lists.newArrayList();
    private ObjectDataRequest objectDataRequest;
    private FileDataRequest fileDataRequest;
    private String contentValue;
    private String content;
    private String imageUri;
    @JsonProperty("isValid")
    private boolean valid;
    private String validationMessage;
    @Builder.Default
    private List<EngineValue> tags = Lists.newArrayList();
}
