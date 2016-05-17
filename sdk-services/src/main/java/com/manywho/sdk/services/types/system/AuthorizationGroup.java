package com.manywho.sdk.services.types.system;

import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.services.types.Type;

@Type.Element(name = "GroupAuthorizationGroup")
public class AuthorizationGroup implements Type {

    @Type.Identifier
    @Type.Property(name = "AuthenticationId", contentType = ContentType.String)
    private String id;

    @Type.Property(name = "FriendlyName", contentType = ContentType.String)
    private String name;

    @Type.Property(name = "DeveloperSummary", contentType = ContentType.String)
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
