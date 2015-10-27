package com.manywho.sdk.entities.run.elements.config;

import com.manywho.sdk.entities.social.Attachment;
import com.manywho.sdk.entities.social.NewMessage;

public class SocialServiceRequest extends ServiceRequest {
    private NewMessage newMessage;
    private String page;
    private int pageSize;
    private Attachment attachment;

    public NewMessage getNewMessage() {
        return newMessage;
    }

    public SocialServiceRequest setNewMessage(NewMessage newMessage) {
        this.newMessage = newMessage;
        return this;
    }

    public String getPage() {
        return page;
    }

    public SocialServiceRequest setPage(String page) {
        this.page = page;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public SocialServiceRequest setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public SocialServiceRequest setAttachment(Attachment attachment) {
        this.attachment = attachment;
        return this;
    }
}
