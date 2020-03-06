package com.manywho.sdk.services.types.system;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

import java.time.OffsetDateTime;
import java.util.UUID;

@Type.Element(name = "$State")
public class $State implements Type {
    @Type.Property(name = "Current Map Element Developer Name", contentType = ContentType.String)
    protected String currentMapElementDeveloperName;

    @Type.Property(name = "Current Map Element ID", contentType = ContentType.String)
    protected UUID currentMapElementId;

    @Type.Property(name = "Date Created", contentType = ContentType.DateTime)
    protected OffsetDateTime dateCreated;

    @Type.Property(name = "Date Modified", contentType = ContentType.DateTime)
    protected OffsetDateTime dateModified;

    @Type.Property(name = "External ID", contentType = ContentType.String)
    protected String externalId;

    @Type.Property(name = "Flow Developer Name", contentType = ContentType.String)
    protected String flowDeveloperName;

    @Type.Property(name = "Flow ID", contentType = ContentType.String)
    protected UUID flowId;

    @Type.Property(name = "Flow Version ID", contentType = ContentType.String)
    protected UUID flowVersionId;

    @Type.Identifier
    @Type.Property(name = "ID", contentType = ContentType.String)
    protected UUID id;

    @Type.Property(name = "Is Done?", contentType = ContentType.Boolean)
    protected boolean done;

    @Type.Property(name = "Join URI", contentType = ContentType.String)
    protected String joinUri;

    @Type.Property(name = "Owner Email", contentType = ContentType.String)
    protected String ownerEmail;

    @Type.Property(name = "Owner First Name", contentType = ContentType.String)
    protected String ownerFirstName;

    @Type.Property(name = "Owner ID", contentType = ContentType.String)
    protected String ownerId;

    @Type.Property(name = "Owner Last Name", contentType = ContentType.String)
    protected String ownerLastName;

    @Type.Property(name = "Owner Name", contentType = ContentType.String)
    protected String ownerName;

    @Type.Property(name = "Owner User ID", contentType = ContentType.String)
    protected String ownerUserId;

    @Type.Property(name = "Owner Username", contentType = ContentType.String)
    protected String ownerUsername;

    @Type.Property(name = "Parent ID", contentType = ContentType.String)
    protected UUID parentId;

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

    public boolean isDone() {
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
