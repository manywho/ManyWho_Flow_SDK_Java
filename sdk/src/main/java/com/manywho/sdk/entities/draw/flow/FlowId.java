package com.manywho.sdk.entities.draw.flow;

import javax.validation.constraints.NotNull;

public class FlowId {
    @NotNull
    private String id;
    private String versionId;

    public FlowId() {

    }

    public FlowId(String id) {
        this(id, null);
    }

    public FlowId(String id, String versionId) {
        this.id = id;
        this.versionId = versionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }
}
