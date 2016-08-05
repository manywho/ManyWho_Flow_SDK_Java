package com.manywho.sdk.services.types.system;

import com.manywho.sdk.enums.ContentType;
import com.manywho.sdk.services.annotations.TypeElement;
import com.manywho.sdk.services.annotations.TypeProperty;
import org.joda.time.DateTime;

import java.util.UUID;

@TypeElement(name = "$State")
public class $State {
    @TypeProperty(name = "Current Map Element Developer Name", contentType = ContentType.String)
    private String currentMapElementDeveloperName;

    @TypeProperty(name = "Current Map Element ID", contentType = ContentType.String)
    private UUID currentMapElementId;

    @TypeProperty(name = "Date Created", contentType = ContentType.DateTime)
    private DateTime dateCreated;

    @TypeProperty(name = "Date Modified", contentType = ContentType.DateTime)
    private DateTime dateModified;

    @TypeProperty(name = "External ID", contentType = ContentType.String)
    private String externalId;

    @TypeProperty(name = "Flow Developer Name", contentType = ContentType.String)
    private String flowDeveloperName;

    @TypeProperty(name = "Flow ID", contentType = ContentType.String)
    private UUID flowId;

    @TypeProperty(name = "Flow Version ID", contentType = ContentType.String)
    private UUID flowVersionId;

    @TypeProperty(name = "ID", contentType = ContentType.String)
    private UUID id;

    @TypeProperty(name = "Is Done?", contentType = ContentType.String)
    private int done;

    @TypeProperty(name = "Join URI", contentType = ContentType.String)
    private String joinUri;

    @TypeProperty(name = "Owner Email", contentType = ContentType.String)
    private String ownerEmail;

    @TypeProperty(name = "Owner First Name", contentType = ContentType.String)
    private String ownerFirstName;

    @TypeProperty(name = "Owner ID", contentType = ContentType.String)
    private String ownerId;

    @TypeProperty(name = "Owner Last Name", contentType = ContentType.String)
    private String ownerLastName;

    @TypeProperty(name = "Owner Name", contentType = ContentType.String)
    private String ownerName;

    @TypeProperty(name = "Owner User ID", contentType = ContentType.String)
    private String ownerUserId;

    @TypeProperty(name = "Owner Username", contentType = ContentType.String)
    private String ownerUsername;

    @TypeProperty(name = "Parent ID", contentType = ContentType.String)
    private UUID parentId;

    public String getCurrentMapElementDeveloperName() {
        return currentMapElementDeveloperName;
    }

    public UUID getCurrentMapElementId() {
        return currentMapElementId;
    }

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public DateTime getDateModified() {
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
