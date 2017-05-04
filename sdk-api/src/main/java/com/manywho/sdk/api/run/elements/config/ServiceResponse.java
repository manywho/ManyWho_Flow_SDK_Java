package com.manywho.sdk.api.run.elements.config;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.manywho.sdk.api.InvokeType;
import com.manywho.sdk.api.run.EngineValue;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ServiceResponse extends AbstractResponse {
    private InvokeType invokeType;
    private String waitMessage;
    private List<EngineValue> outputs = Lists.newArrayList();
    private UUID selectedOutcomeId;
    private Map<String, String> rootFaults = Maps.newHashMap();
    private List<ValueFault> valueFaults = Lists.newArrayList();
    private String mode;

    public ServiceResponse() {

    }

    public ServiceResponse(InvokeType invokeType, List<EngineValue> outputs, String token, String waitMessage) {
        this.invokeType = invokeType;
        this.outputs = MoreObjects.firstNonNull(outputs, Lists.newArrayList());
        this.token = token;
        this.waitMessage = waitMessage;
    }

    public ServiceResponse(UUID tenant, InvokeType invokeType, List<EngineValue> outputs, String token, String waitMessage) {
        this(invokeType, outputs, token, waitMessage);
        this.tenantId = tenant;
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
        this.outputs = MoreObjects.firstNonNull(outputs, Lists.newArrayList());
    }

    public UUID getSelectedOutcomeId() {
        return selectedOutcomeId;
    }

    public void setSelectedOutcomeId(UUID selectedOutcomeId) {
        this.selectedOutcomeId = selectedOutcomeId;
    }

    public Map<String, String> getRootFaults() {
        return rootFaults;
    }

    public void addRootFault(String key, String value) {
        this.rootFaults.put(key, value);
    }

    public void setRootFaults(Map<String, String> rootFaults) {
        this.rootFaults = MoreObjects.firstNonNull(rootFaults, Maps.newHashMap());
    }

    public List<ValueFault> getValueFaults() {
        return valueFaults;
    }

    public void setValueFaults(List<ValueFault> valueFaults) {
        this.valueFaults = MoreObjects.firstNonNull(valueFaults, Lists.newArrayList());
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
