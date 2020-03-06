package com.manywho.sdk.api.run.elements.ui;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageContainerResponse {
    private UUID id;
    private String containerType;
    private String developerName;
    private String label;
    @Builder.Default
    private List<PageContainerResponse> pageContainerResponses = Lists.newArrayList();
    private int order;
    @Builder.Default
    private Map<String, String> attributes = Maps.newHashMap();
}
