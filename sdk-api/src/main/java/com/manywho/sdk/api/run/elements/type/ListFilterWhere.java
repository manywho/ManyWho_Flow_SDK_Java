package com.manywho.sdk.api.run.elements.type;

import com.manywho.sdk.api.CriteriaType;
import com.manywho.sdk.api.run.PropertyAware;

import java.util.List;

public class ListFilterWhere implements PropertyAware {
    private String columnName;
    private CriteriaType criteriaType;
    /**
     * @deprecated use {@link #contentValue} instead
     */
    @Deprecated
    private String value;
    private String contentValue;
    private List<MObject> objectData;

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

    public List<MObject> getObjectData() {
        return objectData;
    }

    public void setObjectData(List<MObject> objectData) {
        this.objectData = objectData;
    }
}
