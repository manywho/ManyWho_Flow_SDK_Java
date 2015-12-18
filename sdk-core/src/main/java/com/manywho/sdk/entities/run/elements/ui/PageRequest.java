package com.manywho.sdk.entities.run.elements.ui;

public class PageRequest {
    private PageComponentInputResponseRequestCollection pageComponentInputResponses;

    public PageComponentInputResponseRequestCollection getPageComponentInputResponses() {
        return pageComponentInputResponses;
    }

    public void addPageComponentInputResponse(PageComponentInputResponseRequest pageComponentInputResponseRequest) {
        if (this.pageComponentInputResponses == null) {
            this.pageComponentInputResponses = new PageComponentInputResponseRequestCollection();
        }

        this.pageComponentInputResponses.add(pageComponentInputResponseRequest);
    }

    public void setPageComponentInputResponses(PageComponentInputResponseRequestCollection pageComponentInputResponses) {
        this.pageComponentInputResponses = pageComponentInputResponses;
    }
}
