package com.manywho.sdk.entities;

import com.manywho.sdk.enums.InvokeType;

import java.util.Dictionary;

public class ServiceResponse implements ResponseInterface {
    private String token;
    private String tenantId;
    private InvokeType invokeType;
    private String waitMessage;
    private EngineValueCollection outputs;
    private String selectedOutcomeId;
    private Culture culture;
    private Dictionary<String, String> rootFaults;
    private ValueFaultCollection valueFaults;
    private String mode;
    private Dictionary<String, String> annotations;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public InvokeType getInvokeType() {
        return invokeType;
    }

    public void setInvokeType(InvokeType invokeType) {
        this.invokeType = invokeType;
    }

    public String getWaitMessage() {
        return waitMessage;
    }

    public void setWaitMessage(String waitMessage) {
        this.waitMessage = waitMessage;
    }

    public EngineValueCollection getOutputs() {
        return outputs;
    }

    public void setOutputs(EngineValueCollection outputs) {
        this.outputs = outputs;
    }

    public String getSelectedOutcomeId() {
        return selectedOutcomeId;
    }

    public void setSelectedOutcomeId(String selectedOutcomeId) {
        this.selectedOutcomeId = selectedOutcomeId;
    }

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public Dictionary<String, String> getRootFaults() {
        return rootFaults;
    }

    public void setRootFaults(Dictionary<String, String> rootFaults) {
        this.rootFaults = rootFaults;
    }

    public ValueFaultCollection getValueFaults() {
        return valueFaults;
    }

    public void setValueFaults(ValueFaultCollection valueFaults) {
        this.valueFaults = valueFaults;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Dictionary<String, String> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Dictionary<String, String> annotations) {
        this.annotations = annotations;
    }
}
