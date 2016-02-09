package com.manywho.sdk.entities.run.elements.type;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ListFilter {
    private String id;
    private String comparisonType;
    private boolean filterByProvidedObjects;
    private ListFilterWhereCollection where;
    private String orderByPropertyDeveloperName;
    private String orderByDirectionType;
    private int limit;
    private int offset;
    private String search;
    private List<SearchCriteria> searchCriteria = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComparisonType() {
        return comparisonType;
    }

    public void setComparisonType(String comparisonType) {
        this.comparisonType = comparisonType;
    }

    public boolean isFilterByProvidedObjects() {
        return filterByProvidedObjects;
    }

    public void setFilterByProvidedObjects(boolean filterByProvidedObjects) {
        this.filterByProvidedObjects = filterByProvidedObjects;
    }

    public ListFilterWhereCollection getWhere() {
        return where;
    }

    public void setWhere(ListFilterWhereCollection where) {
        this.where = where;
    }

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

    public List<SearchCriteria> getSearchCriteria() {
        return searchCriteria;
    }

    public boolean hasSearchCriteria() {
        return CollectionUtils.isNotEmpty(searchCriteria);
    }

    public ListFilter addSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria.add(searchCriteria);
        return this;
    }

    public ListFilter removeSearchCriteria(SearchCriteria searchCriteria) {
        this.searchCriteria.remove(searchCriteria);
        return this;
    }

    public ListFilter setSearchCriteria(List<SearchCriteria> searchCriteria) {
        this.searchCriteria = searchCriteria;
        return this;
    }

    public static class SearchCriteria {
        private String columnName;

        public SearchCriteria() {}

        public SearchCriteria(String columnName) {
            this.columnName = columnName;
        }

        public String getColumnName() {
            return columnName;
        }
    }
}
