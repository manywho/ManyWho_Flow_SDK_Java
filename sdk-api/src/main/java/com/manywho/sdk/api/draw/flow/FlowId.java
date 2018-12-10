package com.manywho.sdk.api.draw.flow;

import java.util.UUID;

public class FlowId {
    private UUID id;
    private UUID versionId;

    public FlowId() {

    }

    public FlowId(UUID id) {
        this(id, null);
    }

    public FlowId(UUID id, UUID versionId) {
        this.id = id;
        this.versionId = versionId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getVersionId() {
        return versionId;
    }

    public void setVersionId(UUID versionId) {
        this.versionId = versionId;
    }
}
