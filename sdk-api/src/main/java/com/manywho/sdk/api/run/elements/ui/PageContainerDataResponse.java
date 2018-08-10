package com.manywho.sdk.api.run.elements.ui;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.run.EngineValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageContainerDataResponse {
    private UUID pageContainerId;
    @JsonProperty("isEnabled")
    private boolean enabled;
    @JsonProperty("isEditable")
    private boolean editable;
    @JsonProperty("isVisible")
    private boolean visible;
    @Builder.Default
    private List<EngineValue> tags = Lists.newArrayList();
}
