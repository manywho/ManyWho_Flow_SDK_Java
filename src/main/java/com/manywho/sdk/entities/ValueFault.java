package com.manywho.sdk.entities;

public class ValueFault {
    private String valueElementToReferenceId;
    private String valueElementTypeElementPropertyToReferenceId;
    private String faultCode;
    private String faultMessage;

    public String getValueElementToReferenceId() {
        return valueElementToReferenceId;
    }

    public void setValueElementToReferenceId(String valueElementToReferenceId) {
        this.valueElementToReferenceId = valueElementToReferenceId;
    }

    public String getValueElementTypeElementPropertyToReferenceId() {
        return valueElementTypeElementPropertyToReferenceId;
    }

    public void setValueElementTypeElementPropertyToReferenceId(String valueElementTypeElementPropertyToReferenceId) {
        this.valueElementTypeElementPropertyToReferenceId = valueElementTypeElementPropertyToReferenceId;
    }

    public String getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(String faultCode) {
        this.faultCode = faultCode;
    }

    public String getFaultMessage() {
        return faultMessage;
    }

    public void setFaultMessage(String faultMessage) {
        this.faultMessage = faultMessage;
    }
}
