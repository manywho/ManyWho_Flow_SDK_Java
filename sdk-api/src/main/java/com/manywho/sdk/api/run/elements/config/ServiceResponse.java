package com.manywho.sdk.api.run.elements.config;

import com.google.common.collect.Lists;
import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.EngineValue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceResponse extends AbstractResponse {
    private InvokeType invokeType;
    private String waitMessage;
    private List<EngineValue> outputs;
    private String selectedOutcomeId;
    private Map<String, String> rootFaults;
    private List<ValueFault> valueFaults;
    private String mode;

    public ServiceResponse() {

    }

    public ServiceResponse(InvokeType invokeType, List<EngineValue> outputs, String token, String waitMessage) {
        this.invokeType = invokeType;
        this.outputs = outputs;
        this.token = token;
        this.waitMessage = waitMessage;
    }

    public ServiceResponse(InvokeType invokeType, List<EngineValue> outputs, String token) {
        this(invokeType, outputs, token, null);
    }

    public ServiceResponse(InvokeType invokeType, EngineValue output, String token, String waitMessage) {
        this(invokeType, Lists.newArrayList(output), token, waitMessage);
    }

    public ServiceResponse(InvokeType invokeType, EngineValue output, String token) {
        this(invokeType, Lists.newArrayList(output), token, null);
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

    public List<EngineValue> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<EngineValue> outputs) {
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

    public List<ValueFault> getValueFaults() {
        return valueFaults;
    }

    public void setValueFaults(List<ValueFault> valueFaults) {
        this.valueFaults = valueFaults;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
