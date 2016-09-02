package com.manywho.sdk.api.run.elements.config;

import java.util.UUID;

public class ValueFault {
    private UUID valueElementToReferenceId;
    private UUID valueElementTypeElementPropertyToReferenceId;
    private String faultCode;
    private String faultMessage;

    public UUID getValueElementToReferenceId() {
        return valueElementToReferenceId;
    }

    public void setValueElementToReferenceId(UUID valueElementToReferenceId) {
        this.valueElementToReferenceId = valueElementToReferenceId;
    }

    public UUID getValueElementTypeElementPropertyToReferenceId() {
        return valueElementTypeElementPropertyToReferenceId;
    }

    public void setValueElementTypeElementPropertyToReferenceId(UUID valueElementTypeElementPropertyToReferenceId) {
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
