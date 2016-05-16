package com.manywho.sdk.api.run.elements.ui;

import java.util.ArrayList;
import java.util.List;

public class PageRequest {
    private List<PageComponentInputResponseRequest> pageComponentInputResponses;

    public List<PageComponentInputResponseRequest> getPageComponentInputResponses() {
        return pageComponentInputResponses;
    }

    public void addPageComponentInputResponse(PageComponentInputResponseRequest pageComponentInputResponseRequest) {
        if (this.pageComponentInputResponses == null) {
            this.pageComponentInputResponses = new ArrayList<>();
        }

        this.pageComponentInputResponses.add(pageComponentInputResponseRequest);
    }

    public void setPageComponentInputResponses(List<PageComponentInputResponseRequest> pageComponentInputResponses) {
        this.pageComponentInputResponses = pageComponentInputResponses;
    }
}
