package com.manywho.sdk.entities.run.elements.config;

import com.manywho.sdk.entities.run.EngineValue;
import com.manywho.sdk.entities.run.EngineValueCollection;
import com.manywho.sdk.enums.InvokeType;

import java.util.HashMap;
import java.util.Map;

public class ServiceResponse extends AbstractResponse {
    private InvokeType invokeType;
    private String waitMessage;
    private EngineValueCollection outputs;
    private String selectedOutcomeId;
    private Map<String, String> rootFaults;
    private ValueFaultCollection valueFaults;
    private String mode;

    public ServiceResponse() {

    }

    public ServiceResponse(InvokeType invokeType, EngineValueCollection outputs, String token, String waitMessage) {
        this.invokeType = invokeType;
        this.outputs = outputs;
        this.token = token;
        this.waitMessage = waitMessage;
    }

    public ServiceResponse(InvokeType invokeType, EngineValueCollection outputs, String token) {
        this(invokeType, outputs, token, null);
    }

    public ServiceResponse(InvokeType invokeType, EngineValue output, String token, String waitMessage) {
        this(invokeType, new EngineValueCollection(output), token, waitMessage);
    }

    public ServiceResponse(InvokeType invokeType, EngineValue output, String token) {
        this(invokeType, new EngineValueCollection(output), token, null);
    }

    public ServiceResponse(InvokeType invokeType, String token, String waitMessage) {
        this.invokeType = invokeType;
        this.token = token;
        this.waitMessage = waitMessage;
    }

    public ServiceResponse(InvokeType invokeType, String token) {
        this(invokeType, token, null);
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

    public Map<String, String> getRootFaults() {
        return rootFaults;
    }

    public void addRootFault(String key, String value) {
        if (this.rootFaults == null) {
            this.rootFaults = new HashMap<>();
        }

        this.rootFaults.put(key, value);
    }

    public void setRootFaults(Map<String, String> rootFaults) {
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
