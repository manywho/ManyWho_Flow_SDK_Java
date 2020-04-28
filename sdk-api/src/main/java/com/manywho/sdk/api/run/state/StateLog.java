package com.manywho.sdk.api.run.state;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class StateLog {
    private List<StateLogEntry> stateLogEntries = Lists.newArrayList();

    public List<StateLogEntry> getStateLogEntries() {
        return stateLogEntries;
    }

    public void setStateLogEntries(List<StateLogEntry> stateLogEntries) {
        this.stateLogEntries = MoreObjects.firstNonNull(stateLogEntries, new ArrayList<StateLogEntry>());
    }
}
