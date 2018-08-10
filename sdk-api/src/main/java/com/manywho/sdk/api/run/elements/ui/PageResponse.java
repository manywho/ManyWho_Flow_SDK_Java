package com.manywho.sdk.api.run.elements.ui;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.manywho.sdk.api.run.EngineValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse {
    private String label;
    @Builder.Default
    private List<PageContainerResponse> pageContainerResponses = Lists.newArrayList();
    @Builder.Default
    private List<PageComponentResponse> pageComponentResponses = Lists.newArrayList();
    @Builder.Default
    private List<PageComponentDataResponse> pageComponentDataResponses = Lists.newArrayList();
    @Builder.Default
    private List<PageContainerDataResponse> pageContainerDataResponses = Lists.newArrayList();
    @Builder.Default
    private List<EngineValue> tags = Lists.newArrayList();
    @Builder.Default
    private Map<String, String> attributes = Maps.newHashMap();
    private int order;

    public boolean hasPageComponentDataResponses() {
        return !pageComponentDataResponses.isEmpty();
    }

    public boolean hasPageComponentResponses() {
        return !pageComponentResponses.isEmpty();
    }

    public boolean hasPageContainerDataResponses() {
        return !pageContainerDataResponses.isEmpty();
    }

    public boolean hasPageContainerResponses() {
        return !pageContainerResponses.isEmpty();
    }

    public void setPageContainerDataResponses(List<PageContainerDataResponse> pageContainerDataResponses) {
        this.pageContainerDataResponses = MoreObjects.firstNonNull(pageContainerDataResponses, new ArrayList<PageContainerDataResponse>());
    }
}
