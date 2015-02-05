package com.manywho.sdk.entities.run.elements.config;

import com.manywho.sdk.entities.run.EngineValue;
import com.manywho.sdk.entities.run.EngineValueCollection;
import com.manywho.sdk.enums.InvokeType;

import java.util.Dictionary;

public class ServiceResponse extends AbstractResponse {
    private InvokeType invokeType;
    private String waitMessage;
    private EngineValueCollection outputs;
    private String selectedOutcomeId;
    private Dictionary<String, String> rootFaults;
    private ValueFaultCollection valueFaults;
    private String mode;

    public ServiceResponse() {

    }

    public ServiceResponse(InvokeType invokeType, EngineValueCollection outputs, String token) {
        this.invokeType = invokeType;
        this.outputs = outputs;
        this.token = token;
    }

    public ServiceResponse(InvokeType invokeType, EngineValue output, String token) {
        this(invokeType, new EngineValueCollection() {{
            add(output);
        }}, token);
    }

    public ServiceResponse(InvokeType invokeType, String token) {
        this.invokeType = invokeType;
        this.token = token;
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
}
