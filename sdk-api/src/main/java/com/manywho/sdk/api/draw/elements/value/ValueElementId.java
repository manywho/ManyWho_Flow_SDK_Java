package com.manywho.sdk.api.draw.elements.value;

import java.util.UUID;

public class ValueElementId {
    private UUID id;
    private UUID typeElementPropertyId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTypeElementPropertyId() {
        return typeElementPropertyId;
    }

    public void setTypeElementPropertyId(UUID typeElementPropertyId) {
        this.typeElementPropertyId = typeElementPropertyId;
    }
}
