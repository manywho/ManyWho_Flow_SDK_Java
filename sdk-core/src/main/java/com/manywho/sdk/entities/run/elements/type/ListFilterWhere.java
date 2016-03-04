package com.manywho.sdk.entities.run.elements.type;

import com.manywho.sdk.enums.ComparisonType;
import com.manywho.sdk.enums.CriteriaType;

public class ListFilterWhere {
    private String columnName;
    private CriteriaType criteriaType;
    /**
     * @deprecated use {@link #contentValue} instead
     */
    @Deprecated
    private String value;
    private String contentValue;
    private ObjectCollection objectData;
    private int group;
    private ComparisonType comparisonWithNext;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public CriteriaType getCriteriaType() {
        return criteriaType;
    }

    public void setCriteriaType(CriteriaType criteriaType) {
        this.criteriaType = criteriaType;
    }

    /**
     * @deprecated use {@link #getContentValue()} instead
     * @return the value to use for lookups
     */
    @Deprecated
    public String getValue() {
        return value;
    }

    /**
     * @deprecated use {@link #setContentValue(String)} instead
     * @param value the value to use for lookups
     */
    @Deprecated
    public void setValue(String value) {
        this.value = value;
    }

    public String getContentValue() {
        return contentValue;
    }

    public void setContentValue(String contentValue) {
        this.contentValue = contentValue;
    }

    public ObjectCollection getObjectData() {
        return objectData;
    }

    public void setObjectData(ObjectCollection objectData) {
        this.objectData = objectData;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public ComparisonType getComparisonWithNext() {
        return comparisonWithNext;
    }

    public void setComparisonWithNext(ComparisonType comparisonWithNext) {
        this.comparisonWithNext = comparisonWithNext;
    }
}
