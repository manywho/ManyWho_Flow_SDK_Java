package com.manywho.sdk.entities.run.elements.type;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ListFilter extends ListFilterMinimal {
    private String id;
    private boolean filterByProvidedObjects;
    private String orderByPropertyDeveloperName;
    private String orderByDirectionType;
    private int limit;
    private int offset;
    private String search;
    private List<SearchCriteria> searchCriteria = new ArrayList<>();
    private List<OrderBy> orderBy = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isFilterByProvidedObjects() {
        return filterByProvidedObjects;
    }

    public void setFilterByProvidedObjects(boolean filterByProvidedObjects) {
        this.filterByProvidedObjects = filterByProvidedObjects;
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

    public List<OrderBy> getOrderBy() {
        return orderBy;
    }

    public boolean hasOrderBy() {
        return CollectionUtils.isNotEmpty(orderBy);
    }

    public ListFilter addOrderBy(OrderBy orderBy) {
        this.orderBy.add(orderBy);
        return this;
    }

    public ListFilter removeOrderBy(OrderBy orderBy) {
        this.orderBy.remove(orderBy);
        return this;
    }

    public ListFilter setOrderBy(List<OrderBy> orderBy) {
        this.orderBy = orderBy;
        return this;
    }

    public static class OrderBy {
        private String columnName;
        private String direction;

        public OrderBy() {
        }

        public OrderBy(String columnName, String direction) {
            this.columnName = columnName;
            this.direction = direction;
        }

        public String getColumnName() {
            return columnName;
        }

        public String getDirection() {
            return direction;
        }
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
