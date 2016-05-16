package com.manywho.sdk.api.run.state;

import java.util.List;

public class StateLog {
    private List<StateLogEntry> stateLogEntries;

    public List<StateLogEntry> getStateLogEntries() {
        return stateLogEntries;
    }

    public void setStateLogEntries(List<StateLogEntry> stateLogEntries) {
        this.stateLogEntries = stateLogEntries;
    }
}
