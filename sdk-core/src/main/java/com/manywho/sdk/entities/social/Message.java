package com.manywho.sdk.entities.social;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Message {
    private String id;
    private String repliedToId;
    private String text;
    private DateTime createdDate;
    private Who sender;
    private List<Attachment> attachments = new ArrayList<>();
    private List<Message> comments = new ArrayList<>();
    private List<String> likerIds = new ArrayList<>();
    private String myLikeId;
    private int commentCount;

    public String getId() {
        return id;
    }

    public Message setId(String id) {
        this.id = id;
        return this;
    }

    public String getRepliedToId() {
        return repliedToId;
    }

    public Message setRepliedToId(String repliedToId) {
        this.repliedToId = repliedToId;
        return this;
    }

    public String getText() {
        return text;
    }

    public Message setText(String text) {
        this.text = text;
        return this;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public Message setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Who getSender() {
        return sender;
    }

    public Message setSender(Who sender) {
        this.sender = sender;
        return this;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public Message addAttachment(Attachment attachment) {
        this.attachments.add(attachment);
        return this;
    }

    public Message setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
        return this;
    }

    public List<Message> getComments() {
        return comments;
    }

    public Message addComment(Message comment) {
        this.comments.add(comment);
        return this;
    }

    public Message setComments(List<Message> comments) {
        this.comments = comments;
        return this;
    }

    public List<String> getLikerIds() {
        return likerIds;
    }

    public Message setLikerIds(List<String> likerIds) {
        this.likerIds = likerIds;
        return this;
    }

    public String getMyLikeId() {
        return myLikeId;
    }

    public Message setMyLikeId(String myLikeId) {
        this.myLikeId = myLikeId;
        return this;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public Message setCommentCount(int commentCount) {
        this.commentCount = commentCount;
        return this;
    }
}
