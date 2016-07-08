package com.manywho.sdk.api.run.elements.type;

import com.manywho.sdk.api.ComparisonType;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public class ListFilterMinimal {
    private ComparisonType comparisonType;
    private List<ListFilterWhere> where;
    private List<ListFilterMinimal> listFilters;

    public ComparisonType getComparisonType() {
        return comparisonType;
    }

    public ListFilterMinimal setComparisonType(ComparisonType comparisonType) {
        this.comparisonType = comparisonType;
        return this;
    }

    public List<ListFilterWhere> getWhere() {
        return where;
    }

    public boolean hasWhere() {
        return CollectionUtils.isNotEmpty(where);
    }

    public ListFilterMinimal setWhere(List<ListFilterWhere> where) {
        this.where = where;
        return this;
    }

    public List<ListFilterMinimal> getListFilters() {
        return listFilters;
    }

    public boolean hasListFilters() {
        return CollectionUtils.isNotEmpty(listFilters);
    }

    public ListFilterMinimal setListFilters(List<ListFilterMinimal> listFilters) {
        this.listFilters = listFilters;
        return this;
    }
}
