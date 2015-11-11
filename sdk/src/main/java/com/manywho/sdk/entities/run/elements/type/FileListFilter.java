package com.manywho.sdk.entities.run.elements.type;

public class FileListFilter {
    private String orderByPropertyDeveloperName;
    private String orderByDirectionType;
    private int limit;
    private int offset;
    private String search;

    public String getOrderByPropertyDeveloperName() {
        return orderByPropertyDeveloperName;
    }

    public void setOrderByPropertyDeveloperName(String orderByPropertyDeveloperName) {
        this.orderByPropertyDeveloperName = orderByPropertyDeveloperName;
    }

    public String getOrderByDirectionType() {
        return orderByDirectionType;
    }

    public void setOrderByDirectionType(String orderByDirectionType) {
        this.orderByDirectionType = orderByDirectionType;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
