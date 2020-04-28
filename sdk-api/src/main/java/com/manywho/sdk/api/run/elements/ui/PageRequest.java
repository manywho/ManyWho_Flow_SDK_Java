package com.manywho.sdk.api.run.elements.ui;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class PageRequest {
    private List<PageComponentInputResponseRequest> pageComponentInputResponses = Lists.newArrayList();

    public List<PageComponentInputResponseRequest> getPageComponentInputResponses() {
        return pageComponentInputResponses;
    }

    public void addPageComponentInputResponse(PageComponentInputResponseRequest pageComponentInputResponseRequest) {
        this.pageComponentInputResponses.add(pageComponentInputResponseRequest);
    }

    public void setPageComponentInputResponses(List<PageComponentInputResponseRequest> pageComponentInputResponses) {
        this.pageComponentInputResponses = MoreObjects.firstNonNull(pageComponentInputResponses, new ArrayList<PageComponentInputResponseRequest>());
    }
}
