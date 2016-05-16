package com.manywho.sdk.services.types.system;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;
import com.manywho.sdk.services.values.Value;

import java.time.OffsetDateTime;
import java.util.UUID;

@Type.Element(name = "$State")
public class $State implements Type {
    @Value.Property(name = "Current Map Element Developer Name", contentType = ContentType.String)
    private String currentMapElementDeveloperName;

    @Value.Property(name = "Current Map Element ID", contentType = ContentType.String)
    private UUID currentMapElementId;

    @Value.Property(name = "Date Created", contentType = ContentType.DateTime)
    private OffsetDateTime dateCreated;

    @Value.Property(name = "Date Modified", contentType = ContentType.DateTime)
    private OffsetDateTime dateModified;

    @Value.Property(name = "External ID", contentType = ContentType.String)
    private String externalId;

    @Value.Property(name = "Flow Developer Name", contentType = ContentType.String)
    private String flowDeveloperName;

    @Value.Property(name = "Flow ID", contentType = ContentType.String)
    private UUID flowId;

    @Value.Property(name = "Flow Version ID", contentType = ContentType.String)
    private UUID flowVersionId;

    @Type.Identifier
    @Value.Property(name = "ID", contentType = ContentType.String)
    private UUID id;

    @Value.Property(name = "Is Done?", contentType = ContentType.String)
    private int done;

    @Value.Property(name = "Join URI", contentType = ContentType.String)
    private String joinUri;

    @Value.Property(name = "Owner Email", contentType = ContentType.String)
    private String ownerEmail;

    @Value.Property(name = "Owner First Name", contentType = ContentType.String)
    private String ownerFirstName;

    @Value.Property(name = "Owner ID", contentType = ContentType.String)
    private String ownerId;

    @Value.Property(name = "Owner Last Name", contentType = ContentType.String)
    private String ownerLastName;

    @Value.Property(name = "Owner Name", contentType = ContentType.String)
    private String ownerName;

    @Value.Property(name = "Owner User ID", contentType = ContentType.String)
    private String ownerUserId;

    @Value.Property(name = "Owner Username", contentType = ContentType.String)
    private String ownerUsername;

    @Value.Property(name = "Parent ID", contentType = ContentType.String)
    private UUID parentId;

    public String getCurrentMapElementDeveloperName() {
        return currentMapElementDeveloperName;
    }

    public UUID getCurrentMapElementId() {
        return currentMapElementId;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public OffsetDateTime getDateModified() {
        return dateModified;
    }

    public String getExternalId() {
        return externalId;
    }

    public String getFlowDeveloperName() {
        return flowDeveloperName;
    }

    public UUID getFlowId() {
        return flowId;
    }

    public UUID getFlowVersionId() {
        return flowVersionId;
    }

    public UUID getId() {
        return id;
    }

    public int isDone() {
        return done;
    }

    public String getJoinUri() {
        return joinUri;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public UUID getParentId() {
        return parentId;
    }
}
