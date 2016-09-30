package com.manywho.sdk.api.run.elements.type;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.ComparisonType;

import java.util.List;

public class ListFilterMinimal {
    private ComparisonType comparisonType;
    private List<ListFilterWhere> where = Lists.newArrayList();
    private List<ListFilterMinimal> listFilters = Lists.newArrayList();

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
        return !where.isEmpty();
    }

    public ListFilterMinimal setWhere(List<ListFilterWhere> where) {
        this.where = MoreObjects.firstNonNull(where, Lists.newArrayList());
        return this;
    }

    public List<ListFilterMinimal> getListFilters() {
        return listFilters;
    }

    public boolean hasListFilters() {
        return !listFilters.isEmpty();
    }

    public ListFilterMinimal setListFilters(List<ListFilterMinimal> listFilters) {
        this.listFilters = MoreObjects.firstNonNull(listFilters, Lists.newArrayList());
        return this;
    }
}
