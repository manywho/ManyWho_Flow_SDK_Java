package com.manywho.sdk.entities.draw.flow;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.manywho.sdk.entities.run.Response;
import com.manywho.sdk.entities.security.BuilderWho;

import java.util.Date;

public class FlowResponse extends FlowRequest implements Response {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSZ")
    private Date dateCreated;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSZ")
    private Date dateModified;
    private BuilderWho whoCreated;
    private BuilderWho whoModified;
    private BuilderWho whoOwner;
    private String alertEmail;
    @JsonProperty("isActive")
    private boolean active;
    @JsonProperty("isDefault")
    private boolean isDefault;
    private String comment;

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public BuilderWho getWhoCreated() {
        return whoCreated;
    }

    public void setWhoCreated(BuilderWho whoCreated) {
        this.whoCreated = whoCreated;
    }

    public BuilderWho getWhoModified() {
        return whoModified;
    }

    public void setWhoModified(BuilderWho whoModified) {
        this.whoModified = whoModified;
    }

    public BuilderWho getWhoOwner() {
        return whoOwner;
    }

    public void setWhoOwner(BuilderWho whoOwner) {
        this.whoOwner = whoOwner;
    }

    public String getAlertEmail() {
        return alertEmail;
    }

    public void setAlertEmail(String alertEmail) {
        this.alertEmail = alertEmail;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
