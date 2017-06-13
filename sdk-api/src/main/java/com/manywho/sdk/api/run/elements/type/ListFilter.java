package com.manywho.sdk.api.run.elements.type;

import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class ListFilter extends ListFilterMinimal {
    private String id;
    private boolean filterByProvidedObjects;
    private String orderByPropertyDeveloperName;
    private String orderByDirectionType;
    private Integer limit;
    private Integer offset;
    private String search;
    private List<SearchCriteria> searchCriteria = Lists.newArrayList();
    private List<OrderBy> orderBy = Lists.newArrayList();

    public String getId() {
        return id;
    }

    public boolean hasId() {
        return !Strings.isNullOrEmpty(id);
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

    public boolean hasOrderByPropertyDeveloperName() {
        return orderByPropertyDeveloperName != null || !orderBy.isEmpty();
    }

    public void setOrderByPropertyDeveloperName(String orderByPropertyDeveloperName) {
        this.orderByPropertyDeveloperName = orderByPropertyDeveloperName;
    }

    public String getOrderByDirectionType() {
        return orderByDirectionType;
    }

    public boolean hasOrderByDirectionType() {
        return orderByDirectionType != null || !orderByDirectionType.isEmpty();
    }

    public void setOrderByDirectionType(String orderByDirectionType) {
        this.orderByDirectionType = orderByDirectionType;
    }

    public int getLimit() {
        return limit;
    }

    public boolean hasLimit() {
        if (limit == null || limit == 0) {
            return false;
        }

        return true;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public boolean hasOffset() {
        if (offset == null || offset == 0) {
            return false;
        }

        return true;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getSearch() {
        return search;
    }

    public boolean hasSearch() {
        return search != null;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public List<SearchCriteria> getSearchCriteria() {
        return searchCriteria;
    }

    public boolean hasSearchCriteria() {
        return !searchCriteria.isEmpty();
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
        this.searchCriteria = MoreObjects.firstNonNull(searchCriteria, new ArrayList<SearchCriteria>());
        return this;
    }

    public List<OrderBy> getOrderBy() {
        return orderBy;
    }

    public boolean hasOrderBy() {
        return !orderBy.isEmpty();
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
        this.orderBy = MoreObjects.firstNonNull(orderBy, new ArrayList<OrderBy>());
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
